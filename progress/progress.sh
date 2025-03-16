#!/bin/bash

echo "🔄 Fetching latest commit log..."
git log --pretty=format:"%ad %an %s" --date=format:'%Y-%m-%d' > commit_log.txt

if [ ! -s commit_log.txt ]; then
  echo "❌ Error: No commits found in the repository."
  exit 1
fi

echo "✅ Commit log updated successfully."

# Python 스크립트 실행
python3 view_progress.py

# 사용이 끝난 commit_log.txt 삭제
rm -f commit_log.txt
echo "🧹 Cleanup: commit_log.txt removed."

