class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        count = 0
        max_count = 0
        chars = list(s)
        char_map ={}
        for i in range(len(chars)):
            if chars[i] not in char_map.keys():
                char_map[chars[i]] = 1
                count += 1
            else:
                char_map ={}
                char_map[chars[i]]= 1
                count = 1
            
            max_count = max(count, max_count)
        return max_count
# Wrong. 
# Not considerate restart. 
## a b c c a b c d