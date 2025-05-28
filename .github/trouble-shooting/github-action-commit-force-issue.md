# GitHub Action 커밋 메시지 자동 수정 중 커및 삭제 이슈

## ✅ 이슈 개요

* **문제**: 커및 메시지를 자동으로 수정하는 GitHub Action이 실행되면서,  다른 사람의 squash-merged 커및들을 삭제하고 덕에쌍용하는 현상이 발생
* **상황**: 여러 PR이 같은 시간에 squash & merge되어고, 각 커및마다 GitHub Action이 개별적으로 실행됨
* **결과**: 뒤에 실행된 Action이 이전 커및들을 기준으로 동작하여, 기존 커및 히스토리를 지우고 새로운 커및 하나로 덕에쌍

## Root Cause

* GitHub Action은 squash merge된 커및을 `--amend`한 뒤 `--force`로 push
* 반복적으로 실행된 여러 Action이 동일한 HEAD를 기준으로 할 수 있음
* 뒤에 실행된 Action이 `--force` push를 통해 이전 커및들을 덕에쌍

```
A -- B -- C  (squash merge 순서)
         ↑   Action-C 실행 시 기준 HEAD가 A일 경우
→ C는 A만 기준으로 재커및 → B, C 삭제
```

## 🔧 해결 방법

### 1. `--force-with-lease` 사용

* 리모트의 HEAD가 내가 예상한 HEAD와 같을 때만 push 진행
* 실수로 다른 커및을 덕에쌍하는 것을 방지

```bash
git push --force-with-lease
```

* ⚠️ 충돌이 발생할 경우 처리 로직이 추가로 필요 (Action 중단 또는 건너보기)

---

### ✅ 2. GitHub Action 동시 실행 방지 (`concurrency` 설정)

* 동일 브랜치의 워크플로우가 **동시에 실행되지 않도록** 제한
* `.github/workflows/auto-commit-msg.yml` 파일에 다음 설정 추가

```yaml
concurrency:
  group: commit-message-rewrite-${{ github.ref }}
  cancel-in-progress: false
```

* 이러게 하면 여러 PR이 squash & merge되도 커및 메시지 수정은 순차적으로만 진행됨

---

## 📈 적용 결과

* `--force`로 인해 다른 커및이 덕에쌍되는 문제 방지
* squash merge 이후 커및 메시지 자동 수정이 안정적으로 작동
* 팀 커및 히스토리 보존 및 충돌 예방

---

## 📌 요약 테이블

| 항목    | 내용                                         |
| ----- | ------------------------------------------ |
| 문제    | 커및 메시지 수정 중 기존 커및 삭제                       |
| 원인    | 동시 실행된 Action이 동일 HEAD 기준으로 `--force` push |
| 해결책 ① | `--force-with-lease`로 안전성 확률 확률            |
| **해결책 ②** | `concurrency` 설정으로 동시 실행 차단                |
| 적용 결과 | ✅ 문제 재발 방지 및 워크플로우 안정화                     |

---
