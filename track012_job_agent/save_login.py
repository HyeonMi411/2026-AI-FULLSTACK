# 사람인 로그인 세션 저장 (최초 1회 / 세션 만료 시)
#
# ⚠️ 만들어지는 state.json 에는 로그인 쿠키가 들어 있어서, 이 파일만 있으면 비밀번호 없이
#    내 사람인 계정으로 로그인됩니다. 절대 공유하거나 GitHub 에 올리지 마세요 (.gitignore 포함).
#    공용 PC(학원)에서는 사용 후 삭제하세요.
import os
from playwright.sync_api import sync_playwright

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
STATE_PATH = os.path.join(BASE_DIR, "state.json")

with sync_playwright() as p:
    browser = p.chromium.launch(channel="chrome", headless=False, args=["--start-maximized"])
    context = browser.new_context(no_viewport=True)
    page = context.new_page()
    page.goto("https://www.saramin.co.kr/zf_user/auth")

    print("\n==================================================")
    print("1. 브라우저에서 사람인 로그인을 완료하세요. (소셜 로그인 포함)")
    print("2. 로그인 후 사람인 메인 화면이 보이면 여기서 Enter 를 누르세요.")
    print("==================================================\n")
    input("로그인 완료 후 Enter: ")

    context.storage_state(path=STATE_PATH)
    print(f"✅ 로그인 세션 저장: {STATE_PATH}")
    print("⚠️ state.json 은 공유·커밋 금지. 공용 PC 에서는 사용 후 삭제하세요.")
    browser.close()
