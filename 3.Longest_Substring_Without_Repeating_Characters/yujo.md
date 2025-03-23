# 3. Longest Substring Without Repeating Characters

## 1. Definition

- Return the length of the longest substring without repeating characters.

## 2. First Code. (5min)

```ts
function lengthOfLongestSubstring(s: string): number {
  let maxLength = 0;

  let start = 0;
  let end = 0;

  while (end < s.length) {
    if (!s.slice(start, end).includes(s[end])) {
      end++;
    } else {
      start++;
    }

    maxLength = Math.max(maxLength, end - start);
  }

  return maxLength;
}
```

## 3. First Code Explain

- Uses the sliding window technique
- Checks if the current last character is a duplicate; if not, the end pointer is incremented, and if it is, the start pointer is incremented.
- Calculates the length of the non-duplicated substring, updates and stores the maximum length, then returns it.

## 4. Optimized Code

```ts

```

## 5. Optimized Code Explain

- I couldn't find a way to optimize it further. If someone knows, please let me know.
