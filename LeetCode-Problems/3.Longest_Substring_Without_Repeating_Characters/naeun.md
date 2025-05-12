Q: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

# Solution

- check! to access index of String, use charAt interface.

- time complexity: O(n)
- space : O(1)
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // not duplicated longest subarray
        int result = 0;

        // use left, right index to check the length
        int left = 0;
        int right = left;

        // for an interation
        // set if key exists -> duplicated
        Set<Character> set = new HashSet<>();
        while(left <= right && right < s.length()){
            // if dupl -> increase left until not duplicated
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            } else {
                // target condition which is not duplicated.
                // add right and update length
                result = Math.max(result, right-left+1);
                set.add(s.charAt(right));
                right++;
            }
        }

        return result;
    }
}
```