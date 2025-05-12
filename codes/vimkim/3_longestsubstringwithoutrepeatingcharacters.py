class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        set_ = set()

        l = r = 0
        N = len(s)
        ans = 0

        while r < N:
            if s[r] not in set_:
                set_.add(s[r])
                r += 1
                ans = max(ans, r - l) # length of peaceful period 무사고 기간

            else: # dance
                set_.remove(s[l])
                l += 1 # day 1 -> 2 -> 3 ...

                49th 50 - 99

        return ans