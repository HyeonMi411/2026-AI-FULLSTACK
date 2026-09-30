"""브라우저 없이 핵심 로직 검사:  python test_agent.py   (openpyxl 필요: pip install openpyxl)"""
import os
import tempfile

import agent

bad = 0


def check(name, got, expected):
    global bad
    ok = got == expected
    bad += not ok
    print(("✓" if ok else "✗"), f"{name:<34} → {got}" + ("" if ok else f"   (기대: {expected})"))


print("── 경력 조건 ──")
for text, exp in [("신입", True), ("신입·경력", True), ("경력무관", True), ("경력 3년↑", True),
                  ("경력 5년↑", False), ("경력 2~5년", True), ("경력 4~7년", False), ("경력 5년↓", True),
                  ("경력 10년", False), ("학력무관 정규직", False)]:
    check(text, agent.career_ok(text), exp)

print("── 제외 / 점수 ──")
check("파견 제외", agent.has_excluded_word("[파견] 백엔드"), True)
check("국비 교육생 제외", agent.has_excluded_word("국비지원 교육생 모집"), True)
s1, r1 = agent.score_job("Java Spring Boot 백엔드 개발자", "JPA, MyBatis, Oracle", "신입")
s2, _ = agent.score_job("웹 디자이너 (Design)", "퍼블리싱", "신입")
s3, _ = agent.score_job("Java 개발자 (SI 상주)", "Spring", "경력 1년↑")
check("백엔드 점수 > 디자인 점수", s1 > s2, True)
check("'si' 가 'design' 에 안 걸림", "si(" not in agent.score_job("Design Lead", "", "")[1], True)
check("SI 상주 감점", s3 < s1, True)
print(f"   (예시 점수: 백엔드 {s1} [{r1}] / 디자인 {s2} / SI상주 {s3})")

print("── 링크 / 승인 표시 ──")
check("rec_idx 추출", agent.rec_idx_from_href("/zf_user/jobs/relay/view?view_type=search&rec_idx=51234567"), "51234567")
for mark, exp in [("O", True), ("o", True), ("ㅇ", True), ("○", True), (" O ", True), ("X", False), ("", False), (None, False)]:
    check(f"승인 표시 {mark!r}", agent.is_approved(mark), exp)

print("── 엑셀 저장 → O 표시 → 다시 읽기 ──")
with tempfile.TemporaryDirectory() as d:
    path = os.path.join(d, "추천목록_test.xlsx")
    rows = [{"지원(O/X)": "", "점수": 9, "회사": "A사", "공고명": "Spring 백엔드", "경력": "신입", "지역": "서울",
             "마감": "~10/15", "추천 사유": "java, spring", "링크": agent.job_url("111"), "rec_idx": "111", "결과": ""},
            {"지원(O/X)": "", "점수": 3, "회사": "B사", "공고명": "웹 개발", "경력": "경력무관", "지역": "경기",
             "마감": "상시", "추천 사유": "", "링크": agent.job_url("222"), "rec_idx": "222", "결과": ""}]
    agent.save_xlsx(rows, path)
    wb, ws, header, loaded = agent.load_xlsx(path)
    ws.cell(row=2, column=1, value="O")          # 사용자가 엑셀에서 A사에 O 표시했다고 가정
    ws.cell(row=3, column=1, value="X")
    wb.save(path)
    _, _, header, loaded = agent.load_xlsx(path)
    targets = [r for r in loaded if agent.is_approved(r["지원(O/X)"])]
    check("헤더 유지", header, agent.COLUMNS)
    check("O 표시한 공고만 선택", [r["rec_idx"] for r in targets], ["111"])
    check("링크 칸 표시", loaded[0]["링크"], "공고 보기")

print("── 지원 기록 / 하루 한도 ──")
with tempfile.TemporaryDirectory() as d:
    agent.LOG_PATH = os.path.join(d, "applied_log.csv")
    agent.write_log("111", "A사", "Spring 백엔드", "applied")
    agent.write_log("222", "B사", "웹 개발", "dry_run")
    check("지원 완료 id (드라이런 제외)", agent.applied_ids(), {"111"})
    check("오늘 지원 수", agent.applied_today(), 1)

print("\n" + ("✅ 모두 통과" if bad == 0 else f"❌ 실패 {bad}건"))
