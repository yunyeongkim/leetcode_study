import os
import re
import subprocess
from datetime import datetime
from pathlib import Path
from git import Repo

def extract_week_from_readme():
    readme = Path("README.md")
    if not readme.exists():
        return "weekX"
    lines = readme.read_text(encoding="utf-8").splitlines()
    for line in reversed(lines):
        match = re.search(r'#week(\d+)', line, re.IGNORECASE)
        if match:
            return f"week{match.group(1)}"
    return "weekX"

def extract_problems(repo):
    changed = repo.git.diff("HEAD~1", name_only=True).splitlines()
    problems = []
    for path in changed:
        parts = Path(path).parts
        if (
            len(parts) == 3 
            and parts[0] == "LeetCode-Problems" 
            and parts[2].endswith(".md")
            ):
            problems.append(parts[0])
    return sorted(set(problems))

def get_last_author(repo):
    return repo.git.log("-1", "--pretty=%an").strip()

def is_direct_master_push(repo):
    author = repo.git.log("-1", "--pretty=%an").strip()
    committer = repo.git.log("-1", "--pretty=%cn").strip()
    return author == committer

def set_remote_url_with_token():
    token = os.environ.get("GH_PUSH_TOKEN")
    repo_url = os.environ.get("GITHUB_REPOSITORY")
    remote_url = f"https://x-access-token:{token}@github.com/{repo_url}.git"
    print(f"🔐 Setting remote URL to: {remote_url}")
    subprocess.run(["git", "remote", "set-url", "origin", remote_url], check=True)
    repo = Repo(".")
    for url in repo.remote("origin").urls:
        print(f"✅ Remote URL now: {url}")

def should_amend_commit(repo):
    log = repo.git.log('--oneline', 'HEAD~1..HEAD')
    return len(log.strip().splitlines()) == 1

def rewrite_message(repo, message):
    print("📝 Amending commit message...")
    repo.git.commit('--amend', '-m', message)
    token = os.environ.get("GH_PUSH_TOKEN")
    repo_url = os.environ.get("GITHUB_REPOSITORY")
    remote_url = f"https://x-access-token:{token}@github.com/{repo_url}.git"
    subprocess.run(["git", "push", remote_url, "HEAD:master", "--force"], check=True)

if __name__ == "__main__":
    set_remote_url_with_token()
    repo = Repo(".")

    branch_name = os.environ.get("GITHUB_REF", "").split("/")[-1]
    event_name = os.environ.get("GITHUB_EVENT_NAME", "")
    base_ref = os.environ.get("GITHUB_BASE_REF", "")

    if branch_name == "master":
        if should_amend_commit(repo):
            if is_direct_master_push(repo):
                today = datetime.now().strftime("%Y-%m-%d")
                message = f"Master updates - {today}"
            else:
                week = extract_week_from_readme()
                problems = extract_problems(repo)
                author = get_last_author(repo)
                message = f"{author} - {week} ({', '.join(problems)})"
                print("🔁 Rewriting commit message to:", message)
                rewrite_message(repo, message)
        else:
            print("⏭ Skipping amend: multiple commits detected.")
    else:
        print(f"⏭ Not master branch ({branch_name}), skipping.")
