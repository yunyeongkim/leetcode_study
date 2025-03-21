Q: https://leetcode.com/problems/minimum-size-subarray-sum/description/

# First solution - failed
- time complexity : O(n^2) -> timeout
- space complexity: O(1)
```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;

        // do double iteration 
        // if sum matches target, update result with min value
        for(int left = 0; left < nums.length; left++){
            int temp = 0;
            for(int right = left; right < nums.length; right++){
                temp += nums[right];

                if(temp >= target){
                    result = Math.min(result, right-left+1);
                    break;
                }
            }
        }

        if(result == Integer.MAX_VALUE){
            return 0;
        }
        return result;
    }
}
```

# Second solution
hard to check index boundary and adding step.
- time complexity : O(n)
- space complexity: O(1)
```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        // if sum matches target, update result with min value
        int left = 0;
        int right = left;
        int temp = nums[right];
        // do one iteration with using left index and right index.
        while(left < nums.length && right < nums.length){
            if(target <= temp){
                // else increase left
                result = Math.min(result, right-left+1);
                temp -= nums[left];
                left++;
            } else {
            // increase right if sum < target
                right++;
                if(right >= nums.length){
                    break;
                }
                temp += nums[right];
            }

        }
        if(result == Integer.MAX_VALUE){
            return 0;
        }
        return result;
    }
}
```

---
# other solution
```java
- deal with `for` iteration
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int curSum = 0;

        for (int right = 0; right < nums.length; right++) {
            curSum += nums[right];

            while (curSum >= target) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                }
                curSum -= nums[left];
                left++;
            }
        }
        
        return minLen != Integer.MAX_VALUE ? minLen : 0;        
    }
}
```