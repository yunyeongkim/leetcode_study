import os
import re
import argparse
from pathlib import Path
from collections import defaultdict

SCRIPT_DIR = Path(__file__).resolve().parent
BASE_DIR = SCRIPT_DIR.parent
OUTPUT_DIR = BASE_DIR / "codes"
PROBLEMS_ROOT = BASE_DIR / "LeetCode-Problems"

EXT_MAP = {
    'python': 'py', 'py': 'py',
    'java': 'java',
    'cpp': 'cpp', 'c++': 'cpp',
    'c': 'c',
    'javascript': 'js', 'js': 'js',
    'typescript': 'ts', 'ts': 'ts',
    'kotlin': 'kt', 'kt': 'kt',
    'swift': 'swift',
    'go': 'go', 'golang': 'go',
    'rust': 'rs', 'rs': 'rs',
    'scala': 'scala',
    'ruby': 'rb', 'rb': 'rb'
}

def normalize_problem_name(folder_name: str) -> str:
    folder_name = folder_name.lower()
    prefix = folder_name.split('.')[0]
    slug = re.sub(r'[^a-z0-9]', '', folder_name.split('.', 1)[-1])
    return f"{prefix}_{slug}"

def extract_code_blocks(content: str):
    return re.findall(r"```(\w+)\n(.*?)```", content, re.DOTALL)

def export_codes(target_name=None, debug=False):
    for problem_dir in PROBLEMS_ROOT.iterdir():
        if not problem_dir.is_dir():
            continue

        normalized_name = normalize_problem_name(problem_dir.name)

        for md_file in problem_dir.glob("*.md"):
            author = re.sub(r'[^a-z]', '', md_file.stem.lower())

            # --name 파라미터 있을 경우 필터링
            if target_name and author != target_name.lower():
                continue

            output_author_dir = OUTPUT_DIR / author
            output_author_dir.mkdir(parents=True, exist_ok=True)

            content = md_file.read_text(encoding="utf-8")
            code_blocks = extract_code_blocks(content)

            if not code_blocks:
                if debug:
                    print(f"⚠️  코드 없음: {md_file.relative_to(BASE_DIR)}")
                continue

            lang_counter = defaultdict(int)
            code_found = False

            for lang, code in code_blocks:
                lang = lang.lower()
                code = code.strip()

                if lang not in EXT_MAP or not code:
                    continue

                code_found = True
                ext = EXT_MAP[lang]
                lang_counter[ext] += 1

                suffix = f"_{lang_counter[ext] - 1}" if lang_counter[ext] > 1 else ""
                filename = f"{normalized_name}{suffix}.{ext}"
                output_path = output_author_dir / filename

                if output_path.exists():
                    existing_code = output_path.read_text(encoding='utf-8').strip()
                    if existing_code == code:
                        if debug:
                            print(f"🔁 동일 → 유지: {output_path.relative_to(BASE_DIR)}")
                        continue
                    else:
                        if debug:
                            print(f"🔄 내용 변경 → 업데이트: {output_path.relative_to(BASE_DIR)}")
                else:
                    if debug:
                        print(f"✅ 새 파일 생성: {output_path.relative_to(BASE_DIR)}")

                with open(output_path, 'w', encoding='utf-8') as f:
                    f.write(code)

            if not code_found and debug:
                print(f"⚠️  지원 언어 포함된 코드블럭 없음: {md_file.relative_to(BASE_DIR)} → 스킵")

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Extract code blocks from markdown files.")
    parser.add_argument('--name', type=str, help="Extract only for specified user (based on md filename)")
    parser.add_argument('--debug', action='store_true', help="Enable debug output")

    args = parser.parse_args()
    export_codes(target_name=args.name, debug=args.debug)
