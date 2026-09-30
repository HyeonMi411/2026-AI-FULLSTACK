# ============================================================
# 사람인 공고 추천 → 엑셀에서 확인(O/X) → O 표시 공고만 일괄 지원
#
#   1단계  python agent.py collect   조건에 맞는 공고를 모아 "추천목록_날짜.xlsx" 저장 (지원 안 함)
#   2단계  엑셀에서 "지원(O/X)" 칸에 O / X 표시 후 저장
#   3단계  python agent.py apply     O 표시한 공고만 자동 지원 (하루 한도, 기록, 중복 방지)
#
# ⚠️ 사람인 이용약관은 자동화 프로그램 사용을 제한할 수 있습니다. 계정 제재 위험을 줄이도록
#    지원은 하루 DAILY_LIMIT 건 이하로 천천히 진행합니다. 지원은 취소가 어렵습니다.
# ============================================================

import argparse
import csv
import glob
import os
import random
import re
import time
from datetime import datetime
from urllib.parse import quote, urlparse, parse_qs


# ============================================================
# 1. 검색 조건
# ============================================================

SEARCH_KEYWORDS = [
    "Java Spring 백엔드",
    "웹 개발자 Spring Boot",
    "풀스택 개발자 React",
    "Flutter 앱 개발",
]

REGIONS = {            # 서울 101000 / 경기 102000 / 인천 108000
    "서울": "101000",
    "경기": "102000",
    "인천": "108000",
}

MAX_PAGES = 5          # 검색어·지역별 최대 페이지

# 경력 조건 - 부트캠프 수료 후 웹 개발 전환이면 신입·경력무관이 가장 잘 맞음
INCLUDE_NEWCOMER = True
INCLUDE_ANY_CAREER = True
EXP_MIN = 0
EXP_MAX = 3

# 이 단어가 있으면 추천 목록에서 아예 제외
EXCLUDE_KEYWORDS = ["파견", "프리랜서", "아르바이트", "교육생", "국비", "무급"]


# ============================================================
# 2. 추천 점수 (내 이력서 기준 - 자유롭게 수정)
# ============================================================

SKILL_POINTS = {        # 공고 제목·직무 키워드에 있으면 가산점
    "java": 3, "spring": 3, "jpa": 2, "mybatis": 2, "백엔드": 2, "서버": 1,
    "react": 2, "next.js": 1, "풀스택": 2, "웹개발": 1, "웹 개발": 1,
    "flutter": 2, "dart": 1, "python": 1, "django": 1,
    "oracle": 1, "redis": 1, "rest": 1, "aws": 1, "docker": 1,
}
PENALTY_POINTS = {      # 있으면 감점 (제외까지는 아님)
    "상주": -4, "si": -2, "야간": -2, "교대": -3, "영업": -5,
}
CAREER_POINTS = {"newcomer": 3, "any": 2, "range": 1}


# ============================================================
# 3. 지원 설정
# ============================================================

# True  : 지원 레이어까지 열고 최종 버튼은 누르지 않음 (첫 실행 때 True 로 동작 확인!)
# False : 실제 지원
DRY_RUN = True

DAILY_LIMIT = 40                  # 하루 최대 지원 수 (applied_log.csv 기준)
DELAY_BETWEEN_APPLY = (8.0, 15.0) # 지원 사이 대기(초)
DELAY_BETWEEN_PAGES = (3.0, 5.0)

APPROVE_MARKS = {"o", "ㅇ", "○", "y", "yes", "v", "✔"}   # "지원(O/X)" 칸에서 승인으로 인정하는 표시


# ============================================================
# 4. 경로
# ============================================================

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
STATE_PATH = os.path.join(BASE_DIR, "state.json")       # 로그인 세션 (공유·커밋 금지)
LOG_PATH = os.path.join(BASE_DIR, "applied_log.csv")    # 지원 기록 (중복 방지·일일 한도)
DEBUG_DIR = os.path.join(BASE_DIR, "debug")
os.makedirs(DEBUG_DIR, exist_ok=True)

CARD_SELECTORS = ".item_recruit, div[class*='item_job']"
COLUMNS = ["지원(O/X)", "점수", "회사", "공고명", "경력", "지역", "마감", "추천 사유", "링크", "rec_idx", "결과"]


# ============================================================
# 5. 순수 함수 (test_agent.py 로 브라우저 없이 검사)
# ============================================================

def parse_career_range(text):
    """("newcomer"|"any"|"range"|"unknown", 최소연차, 최대연차)"""
    t = (text or "").replace(" ", "")
    if "경력무관" in t:
        return "any", 0, 99
    if "신입" in t:
        return "newcomer", 0, 0
    m = re.search(r"경력(\d+)~(\d+)년", t)
    if m:
        return "range", int(m.group(1)), int(m.group(2))
    m = re.search(r"경력(\d+)년(↑|이상)", t)
    if m:
        return "range", int(m.group(1)), 99
    m = re.search(r"경력(\d+)년(↓|이하)", t)
    if m:
        return "range", 0, int(m.group(1))
    m = re.search(r"경력(\d+)년", t)
    if m:
        return "range", int(m.group(1)), int(m.group(1))
    if "경력" in t:
        return "range", 1, 99
    return "unknown", 0, 99


def career_ok(text):
    kind, lo, hi = parse_career_range(text)
    if kind == "newcomer":
        return INCLUDE_NEWCOMER
    if kind == "any":
        return INCLUDE_ANY_CAREER
    if kind == "range":
        return lo <= EXP_MAX and hi >= EXP_MIN
    return False


def career_label(text):
    kind, lo, hi = parse_career_range(text)
    if kind == "newcomer":
        return "신입"
    if kind == "any":
        return "경력무관"
    if kind == "range":
        return f"경력 {lo}년↑" if hi >= 99 else f"경력 {lo}~{hi}년"
    return "확인필요"


def has_excluded_word(text):
    t = (text or "").lower()
    return any(w.lower() in t for w in EXCLUDE_KEYWORDS)


def _contains(word, text):
    """영문 단어는 단어 경계로 (예: 'si' 가 'design' 에 걸리지 않게), 한글은 포함 여부로"""
    if word.isascii():
        return re.search(r"(?<![a-z])" + re.escape(word) + r"(?![a-z])", text) is not None
    return word in text


def score_job(title, sector, condition):
    """추천 점수와 사유 (높을수록 내 이력서와 잘 맞음)"""
    text = f"{title} {sector}".lower()
    score, reasons = 0, []
    for word, pt in SKILL_POINTS.items():
        if _contains(word, text):
            score += pt
            reasons.append(word)
    for word, pt in PENALTY_POINTS.items():
        if _contains(word, f"{text} {(condition or '').lower()}"):
            score += pt
            reasons.append(f"{word}({pt})")
    kind, _, _ = parse_career_range(condition)
    score += CAREER_POINTS.get(kind, 0)
    return score, ", ".join(reasons)


def rec_idx_from_href(href):
    if not href:
        return None
    qs = parse_qs(urlparse(href).query)
    if "rec_idx" in qs:
        return qs["rec_idx"][0]
    m = re.search(r"rec_idx=(\d+)", href)
    return m.group(1) if m else None


def job_url(rec_idx):
    return f"https://www.saramin.co.kr/zf_user/jobs/relay/view?rec_idx={rec_idx}"


def make_search_url(keyword, region_code, page_number=1):
    return ("https://www.saramin.co.kr/zf_user/search/recruit"
            f"?searchword={quote(keyword)}&loc_mcd={region_code}"
            f"&recruitPage={page_number}&page={page_number}")


def is_approved(mark):
    return str(mark or "").strip().lower() in APPROVE_MARKS


# ============================================================
# 6. 지원 기록 (중복 방지 + 하루 한도)
# ============================================================

def read_log():
    if not os.path.exists(LOG_PATH):
        return []
    with open(LOG_PATH, encoding="utf-8-sig") as f:
        return list(csv.DictReader(f))


def applied_ids():
    return {r["rec_idx"] for r in read_log() if r.get("result") == "applied" and r.get("rec_idx")}


def applied_today():
    today = datetime.now().strftime("%Y-%m-%d")
    return sum(1 for r in read_log() if r.get("result") == "applied" and r.get("time", "").startswith(today))


def write_log(rec_idx, company, title, result):
    new = not os.path.exists(LOG_PATH)
    with open(LOG_PATH, "a", encoding="utf-8-sig", newline="") as f:
        w = csv.writer(f)
        if new:
            w.writerow(["time", "rec_idx", "company", "title", "result"])
        w.writerow([datetime.now().strftime("%Y-%m-%d %H:%M"), rec_idx or "", company, title, result])


# ============================================================
# 7. 엑셀 (추천 목록 저장 / 읽기)
# ============================================================

def save_xlsx(rows, path):
    from openpyxl import Workbook
    from openpyxl.styles import Alignment, Font, PatternFill
    from openpyxl.worksheet.datavalidation import DataValidation

    wb = Workbook()
    ws = wb.active
    ws.title = "추천목록"
    ws.append(COLUMNS)
    for c in ws[1]:
        c.font = Font(bold=True, color="FFFFFF")
        c.fill = PatternFill("solid", fgColor="2563EB")
        c.alignment = Alignment(horizontal="center")
    link_col = COLUMNS.index("링크") + 1
    for r in rows:
        ws.append([r.get(k, "") for k in COLUMNS])
        if r.get("링크"):
            cell = ws.cell(row=ws.max_row, column=link_col)
            cell.hyperlink = r["링크"]
            cell.value = "공고 보기"
            cell.font = Font(color="0563C1", underline="single")
    widths = {"지원(O/X)": 10, "점수": 6, "회사": 22, "공고명": 50, "경력": 12, "지역": 14,
              "마감": 12, "추천 사유": 30, "링크": 10, "rec_idx": 11, "결과": 18}
    for i, k in enumerate(COLUMNS, start=1):
        ws.column_dimensions[ws.cell(row=1, column=i).column_letter].width = widths.get(k, 12)
    for row in range(2, ws.max_row + 1):
        cell = ws.cell(row=row, column=1)
        cell.fill = PatternFill("solid", fgColor="FFF7D6")
        cell.alignment = Alignment(horizontal="center")
    dv = DataValidation(type="list", formula1='"O,X"', allow_blank=True)
    ws.add_data_validation(dv)
    dv.add(f"A2:A{max(ws.max_row, 2)}")
    ws.freeze_panes = "A2"
    ws.auto_filter.ref = ws.dimensions
    wb.save(path)


def load_xlsx(path):
    from openpyxl import load_workbook
    wb = load_workbook(path)
    ws = wb.active
    header = [c.value for c in ws[1]]
    rows = []
    for idx, values in enumerate(ws.iter_rows(min_row=2, values_only=True), start=2):
        row = {header[i]: (values[i] if i < len(values) else None) for i in range(len(header))}
        row["_row"] = idx
        rows.append(row)
    return wb, ws, header, rows


def latest_list():
    files = sorted(glob.glob(os.path.join(BASE_DIR, "추천목록_*.xlsx")))
    files = [f for f in files if not os.path.basename(f).startswith("~$")]   # 엑셀 임시파일 제외
    return files[-1] if files else None


# ============================================================
# 8. 브라우저 공통
# ============================================================

def text_of(locator):
    try:
        if locator.count() > 0:
            return (locator.first.inner_text() or "").strip()
    except Exception:
        pass
    return ""


def is_logged_in(page):
    try:
        login = page.locator("a:has-text('로그인')")
        return not (login.count() > 0 and login.first.is_visible())
    except Exception:
        return True


def close_extra_tabs(context, main_page):
    for pg in list(context.pages):
        if pg != main_page:
            try:
                pg.close()
            except Exception:
                pass


def find_submit_button(page):
    """최종 '입사지원' 버튼 - 지원 레이어(또는 레이어 안 iframe)에서만 찾음"""
    scoped = [
        page.locator("#quick_apply_layer button.btn_apply"),
        page.locator("#quick_apply_layer button:has-text('입사지원')"),
        page.locator("div[class*='quick_apply'] button:has-text('입사지원')"),
    ]
    for frame in page.frames:
        if frame != page.main_frame and "apply" in (frame.url or "").lower():
            scoped.append(frame.locator("button:has-text('입사지원'), button.btn_apply"))
    for loc in scoped:
        try:
            for i in range(loc.count()):
                btn = loc.nth(i)
                if not btn.is_visible():
                    continue
                txt = (btn.inner_text() or "").strip()
                if "입사지원" in txt and "보기" not in txt:
                    return btn
        except Exception:
            continue
    return None


def open_browser(p):
    browser = p.chromium.launch(channel="chrome", headless=False, args=["--start-maximized"])
    context = browser.new_context(storage_state=STATE_PATH, no_viewport=True)
    return browser, context, context.new_page()


# ============================================================
# 9. 1단계 - 추천 목록 만들기 (지원하지 않음)
# ============================================================

def read_card(card):
    title = text_of(card.locator(".job_tit a, h2 a"))
    href = ""
    try:
        link = card.locator(".job_tit a, h2 a")
        if link.count() > 0:
            href = link.first.get_attribute("href") or ""
    except Exception:
        pass
    immediate = card.locator("button.sri_btn_immediately, a.sri_btn_immediately, "
                             "button:has-text('즉시지원'), a:has-text('즉시지원')").count() > 0
    return {
        "title": title,
        "company": text_of(card.locator(".corp_name a, .corp_name")),
        "condition": text_of(card.locator(".job_condition")),
        "sector": text_of(card.locator(".job_sector")),
        "deadline": text_of(card.locator(".job_date .date, .job_date")),
        "location": text_of(card.locator(".job_condition span")),
        "href": href,
        "immediate": immediate,
    }


def collect():
    from playwright.sync_api import sync_playwright

    done = applied_ids()
    found = {}
    print("=" * 70)
    print("🔎 1단계: 추천 공고 수집 (지원하지 않습니다)")
    print(f"   검색어 {len(SEARCH_KEYWORDS)}개 × 지역 {len(REGIONS)}곳 × 최대 {MAX_PAGES}페이지")
    print("=" * 70)

    with sync_playwright() as p:
        browser, context, page = open_browser(p)
        try:
            for kw in SEARCH_KEYWORDS:
                for region, code in REGIONS.items():
                    for pg in range(1, MAX_PAGES + 1):
                        page.goto(make_search_url(kw, code, pg), wait_until="domcontentloaded")
                        time.sleep(random.uniform(*DELAY_BETWEEN_PAGES))
                        if not is_logged_in(page):
                            print("⚠️ 로그인 세션 만료 - save_login.py 를 다시 실행하세요.")
                            return
                        cards = page.locator(CARD_SELECTORS)
                        n = cards.count()
                        added = 0
                        for i in range(n):
                            try:
                                c = read_card(cards.nth(i))
                            except Exception:
                                continue
                            rid = rec_idx_from_href(c["href"])
                            if not rid or rid in found or rid in done:
                                continue
                            if not c["immediate"]:          # 홈페이지 지원 등 → 자동 지원 불가
                                continue
                            blob = f"{c['title']} {c['company']} {c['sector']} {c['condition']}"
                            if has_excluded_word(blob) or not career_ok(c["condition"]):
                                continue
                            score, reason = score_job(c["title"], c["sector"], c["condition"])
                            found[rid] = {
                                "지원(O/X)": "", "점수": score, "회사": c["company"], "공고명": c["title"],
                                "경력": career_label(c["condition"]), "지역": c["location"],
                                "마감": c["deadline"], "추천 사유": reason, "링크": job_url(rid),
                                "rec_idx": rid, "결과": "",
                            }
                            added += 1
                        print(f"   [{kw} / {region}] {pg}페이지: 공고 {n}개 중 추천 {added}개 (누적 {len(found)})")
                        if n == 0:
                            break
        finally:
            browser.close()

    rows = sorted(found.values(), key=lambda r: (-r["점수"], r["회사"]))
    path = os.path.join(BASE_DIR, f"추천목록_{datetime.now():%Y%m%d_%H%M}.xlsx")
    save_xlsx(rows, path)
    print("\n" + "=" * 70)
    print(f"✅ 추천 {len(rows)}건 저장: {path}")
    print("   엑셀 '지원(O/X)' 칸에 O(지원) 를 표시하고 저장한 뒤  python agent.py apply")
    print("   (빈 칸·X 는 지원하지 않습니다)")
    print("=" * 70)


# ============================================================
# 10. 3단계 - O 표시한 공고만 지원
# ============================================================

def find_apply_button_on_detail(page):
    loc = page.locator("button.sri_btn_immediately, a.sri_btn_immediately, "
                       "button:has-text('즉시지원'), a:has-text('즉시지원'), button:has-text('입사지원')")
    for i in range(loc.count()):
        el = loc.nth(i)
        try:
            if not el.is_visible():
                continue
            txt = (el.inner_text() or "").strip()
            if any(w in txt for w in ["완료", "마감", "홈페이지", "보기"]):
                continue
            return el
        except Exception:
            continue
    return None


def apply(list_path=None):
    from playwright.sync_api import sync_playwright

    path = list_path or latest_list()
    if not path or not os.path.exists(path):
        print("⚠️ 추천 목록이 없습니다. 먼저  python agent.py collect  를 실행하세요.")
        return
    try:
        wb, ws, header, rows = load_xlsx(path)
    except PermissionError:
        print("⚠️ 엑셀 파일이 열려 있습니다. 엑셀을 저장하고 닫은 뒤 다시 실행하세요.")
        return
    result_col = header.index("결과") + 1
    done = applied_ids()
    targets = [r for r in rows if is_approved(r.get("지원(O/X)")) and str(r.get("rec_idx") or "") not in done]
    remaining = DAILY_LIMIT - applied_today()

    print("=" * 70)
    print(f"🚀 3단계: {'🧪 드라이런(제출 안 함)' if DRY_RUN else '🔥 실제 지원'}")
    print(f"   목록: {os.path.basename(path)}")
    print(f"   O 표시 {len(targets)}건 / 오늘 남은 한도 {max(remaining, 0)}건 (하루 {DAILY_LIMIT}건)")
    print("=" * 70)
    if not targets:
        print("지원할 공고가 없습니다. 엑셀 '지원(O/X)' 칸에 O 를 표시하고 저장했는지 확인하세요.")
        return
    if not DRY_RUN:
        if remaining <= 0:
            print("오늘 한도를 모두 사용했습니다. 내일 다시 실행하세요.")
            return
        if input(f"⚠️ 최대 {min(len(targets), remaining)}건을 확인 없이 실제 지원합니다. 계속하려면 YES: ").strip() != "YES":
            print("취소했습니다.")
            return

    count = 0
    with sync_playwright() as p:
        browser, context, page = open_browser(p)
        try:
            for r in targets:
                if not DRY_RUN and count >= remaining:
                    print(f"🎯 오늘 한도({DAILY_LIMIT}건) 도달 - 나머지는 내일 같은 명령으로 이어서 실행하세요.")
                    break
                rid, company, title = str(r["rec_idx"]), r.get("회사") or "", r.get("공고명") or ""
                print(f"\n▶ {company} - {title}")
                result = "error"
                try:
                    close_extra_tabs(context, page)
                    page.goto(job_url(rid), wait_until="domcontentloaded")
                    time.sleep(3)
                    if not is_logged_in(page):
                        print("⚠️ 로그인 세션 만료 - save_login.py 를 다시 실행하세요.")
                        break
                    btn = find_apply_button_on_detail(page)
                    if not btn:
                        result = "no_apply_button"      # 마감·지원완료·홈페이지 지원 등
                    else:
                        pages_before = len(context.pages)
                        btn.click()
                        time.sleep(3)
                        if len(context.pages) > pages_before:
                            result = "external"         # 홈페이지/자사양식 → 직접 지원 필요
                        else:
                            submit = find_submit_button(page)
                            if not submit:
                                result = "no_submit_button"
                                page.screenshot(path=os.path.join(DEBUG_DIR, f"no_submit_{rid}.png"))
                            elif DRY_RUN:
                                result = "dry_run"
                            else:
                                submit.click()
                                time.sleep(3)
                                result = "applied"
                                count += 1
                except Exception as e:
                    print(f"   ⚠️ 오류: {e}")
                finally:
                    close_extra_tabs(context, page)

                print(f"   {'🎉' if result == 'applied' else '🧪' if result == 'dry_run' else '⏭️'} {result}")
                write_log(rid, company, title, result)
                ws.cell(row=r["_row"], column=result_col, value=f"{result} {datetime.now():%m-%d %H:%M}")
                try:
                    wb.save(path)       # 진행 결과를 엑셀 '결과' 칸에도 기록
                except PermissionError:
                    pass                # 엑셀로 열어 둔 경우 저장 생략 (applied_log.csv 에는 기록됨)
                time.sleep(random.uniform(*DELAY_BETWEEN_APPLY) if result == "applied" else random.uniform(2, 4))
        finally:
            browser.close()

    print("\n" + "=" * 70)
    print(f"✨ 완료 - 결과는 엑셀 '결과' 칸과 applied_log.csv 에 기록했습니다.")
    print("   no_apply_button / external = 마감·홈페이지 지원 → 링크로 직접 확인")
    print("=" * 70)


# ============================================================
# 11. 실행
# ============================================================

if __name__ == "__main__":
    ap = argparse.ArgumentParser(description="사람인 공고 추천 → 엑셀 확인 → 일괄 지원")
    ap.add_argument("mode", choices=["collect", "apply"], help="collect: 추천 목록 만들기 / apply: O 표시 공고 지원")
    ap.add_argument("--file", help="apply 에 사용할 추천목록 엑셀 경로 (생략하면 가장 최근 파일)")
    args = ap.parse_args()
    if not os.path.exists(STATE_PATH):
        print("⚠️ state.json 이 없습니다. 먼저  python save_login.py  로 로그인 세션을 저장하세요.")
    elif args.mode == "collect":
        collect()
    else:
        apply(args.file)
