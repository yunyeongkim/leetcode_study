# 📘 LeetCode 스터디 자동화 시스템

이 저장소는 LeetCode 알고리즘 스터디를 위해 다음과 같은 **자동화 시스템**을 갖추고 있습니다.


## 🧩 폴더 구조

```bash
LeetCode-Problems/
├── 123.문제이름/
│   ├── yunyeong.md
│   └── yujo.md
└── ...
codes/
├── yunyeong/
│   └── 123_problemname.py
├── yujo/
│   └── 123_problemname.cpp
```

---

## ⚙️ 자동화 시스템 설명

### 1. ✅ 코드 자동 추출 (extract_codes.py)

- `.md` 파일 내 코드 블록을 감지하여,  
  `codes/<작성자>/<문제이름>.<확장자>` 형식으로 자동 저장합니다.
- 언어에 따라 `.py`, `.java`, `.cpp` 등으로 분류됩니다.
- 같은 언어가 여러 블록일 경우 `_1`, `_2`로 구분됩니다.

> 예: `123.문제이름/yunyeong.md` → `codes/yunyeong/123_problemname.py`

### 2. 📝 커밋 메시지 자동 수정 (rewrite_commit_msg.py)

####  PR이 머지된경우:
- PR을 squash & merge 시, 다음 형식으로 자동 수정됩니다:
```
yunyeong - week7 (123.문제이름, 456.문제이름)
```

---


## 💡 기타 

- 변경된 `.md` 파일에서만 문제 이름 추출
- 이미 동일한 코드가 있으면 overwrite 하지 않음
- README의 마지막 줄에서 `#week10` 등의 주차 정보 추출

---