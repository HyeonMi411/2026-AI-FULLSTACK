
import os
import random
import re
import time
from urllib.parse import quote

from playwright.sync_api import sync_playwright


# ============================================================
# 1. 검색 조건 설정
# ============================================================

SEARCH_KEYWORD = "JAVA SPRING 개발자"


# ------------------------------------------------------------
# 지역
# ------------------------------------------------------------
# 서울 : 101000
# 경기 : 102000
# 인천 : 108000

REGIONS = {
    "서울": "101000",
    "경기": "102000",
    "인천": "108000",
}


# ------------------------------------------------------------
# 경력 조건
# ------------------------------------------------------------

EXP_MIN = 1       # 최소 1년
EXP_MAX = 3       # 최대 3년


# ============================================================
# 2. 실행 설정
# ============================================================

# True  : 테스트만 진행
# False : 실제 입사지원
DRY_RUN = False


# ------------------------------------------------------------
# 지역별 최대 지원 공고 수
# ------------------------------------------------------------

MAX_APPLY_PER_REGION = 5


# ------------------------------------------------------------
# 전체 최대 지원 공고 수
# ------------------------------------------------------------

MAX_APPLY_TOTAL = 15


# ------------------------------------------------------------
# 지역별 최대 페이지 수
#
# 예:
# 5로 설정하면
# 1페이지 ~ 5페이지까지 검색
# ------------------------------------------------------------

MAX_PAGES_PER_REGION = 10


# ============================================================
# 3. 경로 설정
# ============================================================

BASE_DIR = os.path.dirname(
    os.path.abspath(__file__)
)


# 로그인 세션 파일
STATE_PATH = os.path.join(
    BASE_DIR,
    "state.json"
)


# 디버깅 스크린샷
DEBUG_DIR = os.path.join(
    BASE_DIR,
    "debug"
)


os.makedirs(
    DEBUG_DIR,
    exist_ok=True
)


# ============================================================
# 4. 공고 카드 CSS
# ============================================================

CARD_SELECTORS = [
    ".item_recruit",
    "div[class*='item_job']",
    "li[class*='item']",
]


# ============================================================
# 5. 공고 카드 찾기
# ============================================================

def get_cards(page):
    """
    현재 페이지의 채용공고 카드 찾기
    """

    for selector in CARD_SELECTORS:

        try:

            loc = page.locator(selector)

            if loc.count() > 0:

                return loc, selector

        except Exception:

            continue


    return (
        page.locator(
            CARD_SELECTORS[0]
        ),
        CARD_SELECTORS[0]
    )


# ============================================================
# 6. 입사지원 레이어 닫기
# ============================================================

def close_apply_layer(page):

    """
    입사지원 레이어를 닫는다.
    """

    try:

        # ----------------------------------------------------
        # ESC
        # ----------------------------------------------------

        page.keyboard.press(
            "Escape"
        )

        time.sleep(0.5)


        # ----------------------------------------------------
        # 닫기 버튼
        # ----------------------------------------------------

        close_btns = page.locator(
            "#quick_apply_layer .btn_close, "
            ".iframe_layer .btn_close, "
            "#iframe_layer .btn_close, "
            "button[title='닫기'], "
            "a:has-text('닫기')"
        )


        for i in range(
            close_btns.count()
        ):

            try:

                btn = close_btns.nth(i)

                if btn.is_visible():

                    btn.click(
                        force=True
                    )

                    time.sleep(0.5)

            except Exception:

                continue


        # ----------------------------------------------------
        # JavaScript로 레이어 제거
        # ----------------------------------------------------

        page.evaluate(
            """
            () => {

                const layers =
                    document.querySelectorAll(
                        '#quick_apply_layer, ' +
                        '.iframe_layer, ' +
                        '#iframe_layer, ' +
                        '#quick_apply_frame'
                    );

                layers.forEach(
                    el => el.remove()
                );
            }
            """
        )


        time.sleep(0.5)


    except Exception:

        pass


# ============================================================
# 7. 카드 내부 지원 버튼 찾기
# ============================================================

def find_apply_button_in_card(card):

    """
    채용공고 카드 내부의
    입사지원 / 즉시지원 버튼을 찾는다.
    """

    candidates = [

        card.locator(
            "a.sri_btn_immediately, "
            "button.sri_btn_immediately"
        ),

        card.locator(
            "a[class*='btn_apply'], "
            "button[class*='btn_apply']"
        ),

        card.locator(
            "a:has-text('입사지원'), "
            "button:has-text('입사지원')"
        ),

        card.locator(
            "a:has-text('즉시지원'), "
            "button:has-text('즉시지원')"
        ),
    ]


    for loc in candidates:

        try:

            for k in range(
                loc.count()
            ):

                el = loc.nth(k)


                if not el.is_visible():

                    continue


                text = (
                    el.inner_text() or ""
                ).strip()


                if (
                    ("지원" in text
                     or "입사" in text)
                    and
                    not any(
                        word in text
                        for word in [
                            "완료",
                            "마감",
                            "보기"
                        ]
                    )
                ):

                    return el


        except Exception:

            continue


    return None


# ============================================================
# 8. 최종 입사지원 버튼 찾기
# ============================================================

def click_red_layer_submit_button(
    context
):

    """
    입사지원 레이어 내부의
    최종 입사지원 버튼을 찾고 클릭한다.
    """

    targets = []


    # --------------------------------------------------------
    # 모든 페이지
    # --------------------------------------------------------

    for pg in context.pages:

        targets.append(pg)


        # iframe
        for frame in pg.frames:

            targets.append(frame)


    # --------------------------------------------------------
    # 최종 지원 버튼
    # --------------------------------------------------------

    submit_selectors = [

        "#quick_apply_layer "
        "button.btn_apply",

        "#quick_apply_layer "
        ".btn_apply",

        "div[class*='quick_apply'] "
        "button:has-text('입사지원')",

        "div[class*='layer'] "
        "button:has-text('입사지원')",

        "button[class*='btn_apply']",

        "#btn_apply",

        "button:has-text('입사지원')",
    ]


    # --------------------------------------------------------
    # 페이지 / iframe 탐색
    # --------------------------------------------------------

    for target in targets:

        for selector in submit_selectors:

            try:

                buttons = target.locator(
                    selector
                )


                for i in range(
                    buttons.count()
                ):

                    btn = buttons.nth(i)


                    if not btn.is_visible():

                        continue


                    box = btn.bounding_box()


                    if not box:

                        continue


                    # 우측 레이어
                    if box["x"] <= 400:

                        continue


                    # 너무 작은 버튼 제외
                    if box["width"] <= 100:

                        continue


                    text = (
                        btn.inner_text() or ""
                    ).strip()


                    if "보기" in text:

                        continue


                    if "입사지원" not in text:

                        continue


                    # ------------------------------------------------
                    # 드라이런
                    # ------------------------------------------------

                    if DRY_RUN:

                        print(
                            "  🎉 [드라이런] "
                            "최종 입사지원 버튼 발견"
                        )

                        return True


                    # ------------------------------------------------
                    # 실제 지원
                    # ------------------------------------------------

                    btn.click(
                        force=True
                    )


                    print(
                        "  🚀 최종 입사지원 "
                        "버튼 클릭 성공"
                    )


                    return True


            except Exception:

                continue


    return False


# ============================================================
# 9. 로그인 상태 확인
# ============================================================

def check_login(page):

    try:

        login_btn = page.locator(
            "a:has-text('로그인')"
        )


        if login_btn.count() > 0:

            if login_btn.first.is_visible():

                return False


    except Exception:

        pass


    return True


# ============================================================
# 10. 검색 URL 생성
# ============================================================

def make_search_url(
    region_code,
    page_number=1
):

    """
    검색어 + 지역 + 페이지
    """

    url = (
        "https://www.saramin.co.kr/"
        "zf_user/search/recruit"
        f"?searchword={quote(SEARCH_KEYWORD)}"
        f"&loc_mcd={region_code}"
        f"&page={page_number}"
    )


    return url


# ============================================================
# 11. 경력 조건 확인
# ============================================================

def check_experience_in_card(card):

    """
    공고 카드의 경력 조건 확인
    """

    try:

        text = (
            card.inner_text() or ""
        ).strip()


        # ----------------------------------------------------
        # 신입 제외
        # ----------------------------------------------------

        if (
            "신입" in text
            and "경력" not in text
        ):

            return False


        # ----------------------------------------------------
        # 경력무관 제외
        # ----------------------------------------------------

        if "경력무관" in text:

            return False


        # ----------------------------------------------------
        # 연차 검색
        # ----------------------------------------------------

        matches = re.findall(
            r"(\d+)\s*년",
            text
        )


        # ----------------------------------------------------
        # 연차 숫자가 없는 경우
        # ----------------------------------------------------

        if not matches:

            if "경력" in text:

                return True

            return False


        # ----------------------------------------------------
        # 1~3년 확인
        # ----------------------------------------------------

        for value in matches:

            year = int(value)


            if (
                EXP_MIN
                <= year
                <= EXP_MAX
            ):

                return True


        return False


    except Exception:

        return True


# ============================================================
# 12. 다음 페이지 버튼 찾기
# ============================================================

def find_next_page_button(page):

    """
    현재 페이지에서 다음 페이지 버튼을 찾는다.

    반환값:
        버튼 locator
        또는 None
    """

    selectors = [

        # 사람인 일반 페이징
        "a[aria-label='다음 페이지']",

        "a[title='다음 페이지']",

        "a.next",

        ".pagination a.next",

        ".PageNavigation a.next",

        # 텍스트 기반
        "a:has-text('다음')",

        "button:has-text('다음')",
    ]


    for selector in selectors:

        try:

            loc = page.locator(
                selector
            )


            for i in range(
                loc.count()
            ):

                btn = loc.nth(i)


                if not btn.is_visible():

                    continue


                # disabled 확인
                try:

                    if btn.is_disabled():

                        continue

                except Exception:

                    pass


                # 클래스 disabled
                try:

                    class_name = (
                        btn.get_attribute(
                            "class"
                        ) or ""
                    )


                    if (
                        "disabled"
                        in class_name.lower()
                    ):

                        continue

                except Exception:

                    pass


                return btn


        except Exception:

            continue


    return None


# ============================================================
# 13. 특정 페이지 이동
# ============================================================

def go_to_page(
    page,
    region_code,
    page_number
):

    """
    지정된 페이지로 이동한다.
    """

    search_url = make_search_url(
        region_code,
        page_number
    )


    print(
        f"  📄 {page_number}페이지 이동"
    )


    page.goto(
        search_url,
        wait_until="domcontentloaded"
    )


    time.sleep(2)


    return True


# ============================================================
# 14. 지역별 + 페이지별 공고 처리
# ============================================================

def process_region(
    page,
    context,
    region_name,
    region_code,
    total_processed
):

    print("")
    print("=" * 70)
    print(
        f"📍 지역 : {region_name}"
    )
    print(
        f"   지역코드 : {region_code}"
    )
    print(
        f"   경력 : {EXP_MIN}~{EXP_MAX}년"
    )
    print(
        f"   최대 페이지 : "
        f"{MAX_PAGES_PER_REGION}"
    )
    print("=" * 70)


    region_processed = 0


    # ========================================================
    # 페이지 반복
    # ========================================================

    for page_number in range(
        1,
        MAX_PAGES_PER_REGION + 1
    ):

        # ----------------------------------------------------
        # 지역별 최대 지원 수 확인
        # ----------------------------------------------------

        if (
            region_processed
            >= MAX_APPLY_PER_REGION
        ):

            print(
                f"🎯 {region_name} "
                f"지역 최대 지원 수 "
                f"{MAX_APPLY_PER_REGION}개 완료"
            )

            break


        # ----------------------------------------------------
        # 전체 최대 지원 수 확인
        # ----------------------------------------------------

        if (
            total_processed
            >= MAX_APPLY_TOTAL
        ):

            print(
                f"🎯 전체 최대 지원 수 "
                f"{MAX_APPLY_TOTAL}개 완료"
            )

            return total_processed, True


        # ----------------------------------------------------
        # 페이지 이동
        # ----------------------------------------------------

        try:

            go_to_page(
                page,
                region_code,
                page_number
            )

        except Exception as e:

            print(
                f"  ⚠️ 페이지 이동 오류 : {e}"
            )

            continue


        # ----------------------------------------------------
        # 로그인 상태
        # ----------------------------------------------------

        if not check_login(page):

            print(
                "⚠️ 로그인 세션이 "
                "만료되었습니다."
            )

            return total_processed, True


        # ----------------------------------------------------
        # 공고 카드 로딩
        # ----------------------------------------------------

        try:

            page.wait_for_selector(
                ",".join(
                    CARD_SELECTORS
                ),
                state="attached",
                timeout=10000
            )

        except Exception:

            pass


        # ----------------------------------------------------
        # 카드 가져오기
        # ----------------------------------------------------

        cards, card_selector = (
            get_cards(page)
        )


        card_count = cards.count()


        print("")
        print(
            f"📄 [{region_name}] "
            f"{page_number}페이지"
        )

        print(
            f"   🔍 공고 {card_count}개 발견"
        )


        # ----------------------------------------------------
        # 공고가 없으면 종료
        # ----------------------------------------------------

        if card_count == 0:

            print(
                "  ⚠️ 공고가 없습니다."
            )

            break


        # ====================================================
        # 현재 페이지의 공고 반복
        # ====================================================

        for card_index in range(
            card_count
        ):

            # ------------------------------------------------
            # 지역별 최대
            # ------------------------------------------------

            if (
                region_processed
                >= MAX_APPLY_PER_REGION
            ):

                break


            # ------------------------------------------------
            # 전체 최대
            # ------------------------------------------------

            if (
                total_processed
                >= MAX_APPLY_TOTAL
            ):

                return (
                    total_processed,
                    True
                )


            try:

                # ------------------------------------------------
                # 이전 레이어 제거
                # ------------------------------------------------

                close_apply_layer(
                    page
                )


                # ------------------------------------------------
                # 카드 다시 조회
                # ------------------------------------------------

                current_cards, _ = (
                    get_cards(page)
                )


                if (
                    card_index
                    >= current_cards.count()
                ):

                    break


                card = (
                    current_cards.nth(
                        card_index
                    )
                )


                # ------------------------------------------------
                # 카드 화면 이동
                # ------------------------------------------------

                try:

                    card.evaluate(
                        """
                        el =>
                            el.scrollIntoView({
                                block: 'center'
                            })
                        """
                    )

                    time.sleep(0.3)

                except Exception:

                    continue


                # ------------------------------------------------
                # 경력 조건
                # ------------------------------------------------

                if not check_experience_in_card(
                    card
                ):

                    print(
                        f"  ⏭️ 카드 #{card_index} "
                        f"경력 조건 불일치"
                    )

                    continue


                # ------------------------------------------------
                # 지원 버튼
                # ------------------------------------------------

                list_btn = (
                    find_apply_button_in_card(
                        card
                    )
                )


                if not list_btn:

                    print(
                        f"  ⏭️ 카드 #{card_index} "
                        f"지원 버튼 없음"
                    )

                    continue


                # ------------------------------------------------
                # 공고명
                # ------------------------------------------------

                try:

                    card_text = (
                        card.inner_text()
                        or ""
                    ).strip()


                    lines = [
                        line.strip()
                        for line in
                        card_text.split("\n")
                        if line.strip()
                    ]


                    job_title = (
                        lines[0]
                        if lines
                        else "공고명 확인불가"
                    )

                except Exception:

                    job_title = (
                        "공고명 확인불가"
                    )


                # ------------------------------------------------
                # 카운트
                # ------------------------------------------------

                region_processed += 1

                total_processed += 1


                print("")
                print(
                    f"  ▶ [{region_name}] "
                    f"{page_number}페이지 "
                    f"공고 #{card_index}"
                )

                print(
                    f"     📌 {job_title}"
                )

                print(
                    f"     지역 지원 : "
                    f"{region_processed}/"
                    f"{MAX_APPLY_PER_REGION}"
                )

                print(
                    f"     전체 지원 : "
                    f"{total_processed}/"
                    f"{MAX_APPLY_TOTAL}"
                )


                # ------------------------------------------------
                # 목록 지원 버튼 클릭
                # ------------------------------------------------

                print(
                    "     🖱️ 입사지원 버튼 클릭"
                )


                list_btn.click(
                    force=True
                )


                time.sleep(2.5)


                # ------------------------------------------------
                # 최종 지원
                # ------------------------------------------------

                success = (
                    click_red_layer_submit_button(
                        context
                    )
                )


                if success:

                    if DRY_RUN:

                        print(
                            "     🧪 드라이런 "
                            "→ 실제 제출하지 않음"
                        )

                    else:

                        time.sleep(2.5)

                        print(
                            "     🎉 입사지원 제출 완료!"
                        )


                else:

                    print(
                        "     ⚠️ 최종 입사지원 "
                        "버튼을 찾지 못함"
                    )


                    # ------------------------------------------------
                    # 실패 캡처
                    # ------------------------------------------------

                    screenshot_path = os.path.join(
                        DEBUG_DIR,
                        f"{region_name}_"
                        f"page_{page_number}_"
                        f"fail_{region_processed}.png"
                    )


                    try:

                        page.screenshot(
                            path=screenshot_path
                        )

                        print(
                            f"     📸 캡처 : "
                            f"{screenshot_path}"
                        )

                    except Exception:

                        pass


                # ------------------------------------------------
                # 레이어 닫기
                # ------------------------------------------------

                close_apply_layer(
                    page
                )


                # ------------------------------------------------
                # 다음 공고 전 대기
                # ------------------------------------------------

                time.sleep(
                    random.uniform(
                        1.5,
                        2.5
                    )
                )


            except Exception as e:

                print(
                    f"     ⚠️ 공고 처리 오류 : "
                    f"{e}"
                )


                close_apply_layer(
                    page
                )


                continue


        # ========================================================
        # 현재 페이지 완료
        # ========================================================

        print("")
        print(
            f"✅ {region_name} "
            f"{page_number}페이지 처리 완료"
        )


        # --------------------------------------------------------
        # 지역 최대 지원 도달
        # --------------------------------------------------------

        if (
            region_processed
            >= MAX_APPLY_PER_REGION
        ):

            print(
                f"🎯 {region_name} "
                f"최대 지원 수 도달"
            )

            break


        # --------------------------------------------------------
        # 전체 최대 지원 도달
        # --------------------------------------------------------

        if (
            total_processed
            >= MAX_APPLY_TOTAL
        ):

            print(
                "🎯 전체 최대 지원 수 도달"
            )

            return (
                total_processed,
                True
            )


        # ========================================================
        # 다음 페이지 이동
        # ========================================================

        if (
            page_number
            >= MAX_PAGES_PER_REGION
        ):

            print(
                f"📄 {region_name} "
                f"최대 페이지 "
                f"{MAX_PAGES_PER_REGION}에 도달"
            )

            break


        # --------------------------------------------------------
        # 다음 페이지 버튼 확인
        # --------------------------------------------------------

        next_button = (
            find_next_page_button(page)
        )


        if not next_button:

            print(
                "  ℹ️ 다음 페이지 버튼을 "
                "찾지 못했습니다."
            )

            print(
                f"  ✅ {region_name} "
                f"검색 종료"
            )

            break


        # --------------------------------------------------------
        # 다음 페이지 클릭
        # --------------------------------------------------------

        try:

            print(
                f"  ➡️ "
                f"{page_number + 1}페이지로 이동"
            )


            next_button.click(
                force=True
            )


            time.sleep(2)


        except Exception as e:

            print(
                f"  ⚠️ 다음 페이지 이동 실패 : "
                f"{e}"
            )

            # URL 직접 이동
            try:

                go_to_page(
                    page,
                    region_code,
                    page_number + 1
                )

            except Exception:

                print(
                    "  ❌ 다음 페이지 이동 "
                    "최종 실패"
                )

                break


    # ========================================================
    # 지역 처리 완료
    # ========================================================

    print("")
    print(
        f"📍 {region_name} 지역 완료"
    )

    print(
        f"   처리 : "
        f"{region_processed}개"
    )

    return (
        total_processed,
        False
    )


# ============================================================
# 15. 메인 실행
# ============================================================

def run_agent():

    # --------------------------------------------------------
    # state.json 확인
    # --------------------------------------------------------

    if not os.path.exists(
        STATE_PATH
    ):

        print(
            "⚠️ state.json 파일이 없습니다."
        )

        print(
            "먼저 save_login.py를 실행하여 "
            "로그인 세션을 저장해 주세요."
        )

        input(
            "엔터 키를 누르면 종료합니다..."
        )

        return


    # --------------------------------------------------------
    # 실행 모드
    # --------------------------------------------------------

    mode = (
        "🧪 드라이런(테스트)"
        if DRY_RUN
        else "🔥 실제 입사지원"
    )


    # --------------------------------------------------------
    # 실행 정보
    # --------------------------------------------------------

    print("")
    print("=" * 70)
    print(
        "       사람인 자동 조건검색 + 페이징 지원"
    )
    print("=" * 70)

    print(
        f"🔎 검색어 : "
        f"{SEARCH_KEYWORD}"
    )

    print(
        f"📅 경력 : "
        f"{EXP_MIN}~{EXP_MAX}년"
    )

    print(
        "📍 지역 : "
        "서울 / 경기 / 인천"
    )

    print(
        f"📄 지역별 최대 페이지 : "
        f"{MAX_PAGES_PER_REGION}"
    )

    print(
        f"📌 지역별 최대 지원 : "
        f"{MAX_APPLY_PER_REGION}개"
    )

    print(
        f"📌 전체 최대 지원 : "
        f"{MAX_APPLY_TOTAL}개"
    )

    print(
        f"▶ 모드 : {mode}"
    )

    print("=" * 70)


    # --------------------------------------------------------
    # Playwright
    # --------------------------------------------------------

    with sync_playwright() as p:

        browser = p.chromium.launch(

            channel="chrome",

            headless=False,

            args=[
                "--disable-blink-features="
                "AutomationControlled",

                "--start-maximized",
            ],
        )


        # ----------------------------------------------------
        # 로그인 세션
        # ----------------------------------------------------

        context = browser.new_context(

            storage_state=STATE_PATH,

            no_viewport=True,
        )


        page = context.new_page()


        # ----------------------------------------------------
        # 전체 처리 카운트
        # ----------------------------------------------------

        total_processed = 0


        # ====================================================
        # 지역 반복
        # ====================================================

        for (
            region_name,
            region_code
        ) in REGIONS.items():


            # ------------------------------------------------
            # 전체 최대 확인
            # ------------------------------------------------

            if (
                total_processed
                >= MAX_APPLY_TOTAL
            ):

                print(
                    "🎯 전체 최대 지원 수 "
                    "도달"
                )

                break


            # ------------------------------------------------
            # 지역 처리
            # ------------------------------------------------

            (
                total_processed,
                finished
            ) = process_region(

                page,

                context,

                region_name,

                region_code,

                total_processed
            )


            # ------------------------------------------------
            # 로그인 만료 / 전체 종료
            # ------------------------------------------------

            if finished:

                break


            # ------------------------------------------------
            # 지역 변경 대기
            # ------------------------------------------------

            time.sleep(
                random.uniform(
                    2,
                    3
                )
            )


        # ====================================================
        # 종료
        # ====================================================

        print("")
        print("=" * 70)
        print(
            "✨ 모든 검색 및 지원 작업 완료"
        )
        print("=" * 70)

        print(
            f"🔎 검색어 : "
            f"{SEARCH_KEYWORD}"
        )

        print(
            f"📅 경력 : "
            f"{EXP_MIN}~{EXP_MAX}년"
        )

        print(
            "📍 지역 : "
            "서울 / 경기 / 인천"
        )

        print(
            f"📄 지역별 최대 페이지 : "
            f"{MAX_PAGES_PER_REGION}"
        )

        print(
            f"📊 총 처리 공고 : "
            f"{total_processed}개"
        )

        print("=" * 70)


        input(
            "엔터 키를 누르면 "
            "브라우저를 종료합니다..."
        )


        browser.close()


# ============================================================
# 16. 프로그램 시작
# ============================================================

if __name__ == "__main__":

    run_agent()


# 미션1) 조건검색 - 년차1~3 / 지역 : 서울, 인천, 경기
# 미션2) 페이징 - 여러개 지원가능하게
