import re
import sys
from collections import defaultdict

# 파일에서 로그 읽기
log_file = "commit_log.txt"

try:
    with open(log_file, "r", encoding="utf-8") as file:
        logs = file.readlines()
except FileNotFoundError:
    print(f"❌ Error: '{log_file}' not found.")
    sys.exit(1)

# 사용자별 주차별 문제 데이터 저장
progress_data = defaultdict(lambda: defaultdict(int))
user_problems = defaultdict(list)

# 문제 번호만 추출하는 정규식 패턴
problem_pattern = re.compile(r"(\d+)[._](.*?)$")

# 로그 파싱
for log in logs:
    match = re.search(r"(\d{4}-\d{2}-\d{2}) (\w+) .*?week(\d+)\((.*?)\)", log)
    if match:
        _, name, week, problems = match.groups()
        problems_list = [p.strip() for p in problems.split(",")]

        # 사용자별 주차별 문제 개수 저장
        progress_data[name][f"week{week}"] += len(problems_list)

        # 문제 번호를 기준으로 정렬을 위해 리스트에 저장
        for problem in problems_list:
            num_match = problem_pattern.match(problem)
            if num_match:
                problem_number = int(num_match.group(1))  # 문제 번호 숫자로 변환
                problem_title = num_match.group(2)  # 문제 제목
                user_problems[name].append((problem_number, problem_title))

# 사용자 입력 받기
name_input = input("Enter the name (or press Enter for full progress): ").strip()

# (1) 특정 사용자의 풀이 이력 출력 (문제 번호순 정렬)
if name_input:
    if name_input in user_problems:
        sorted_problems = sorted(user_problems[name_input], key=lambda x: x[0])  # 문제 번호 기준 정렬
        print(f"\n📌 {name_input}'s solved problems in order:")
        for idx, (num, title) in enumerate(sorted_problems, 1):
            print(f"{idx}. {num}.{title}")
    else:
        print(f"\n❌ No problems found for {name_input}. Please check the name or commit history.")

# (2) 이름을 입력하지 않으면 전체 진행 상황 출력
else:
    print("\n📊 **Overall Progress:**\n")
    sorted_data = sorted(progress_data.items(), key=lambda x: x[0])  # 이름순 정렬
    for name, weeks in sorted_data:
        print(f"**{name}:**")
        for week, count in sorted(weeks.items()):
            print(f"  {week}: {'█' * count} ({count} problems solved)")
        print()
