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