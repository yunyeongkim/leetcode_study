class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = 0
        max_len = 0
        char_index = {}

        for right in range(len(s)):
            # when duplicated char exist, change left pointer
            if s[right] in char_index and char_index[s[right]] >= left:
                left = char_index[s[right]] + 1

            # renew the current pointer
            char_index[s[right]] = right

            # update window to max
            max_len = max(max_len, right - left + 1)