[problem](https://leetcode.com/problems/subarray-product-less-than-k/description/)


### IDEA
- Use a sliding window approach to maintain the product of current subarray.
- If parameter `k` is 0 or 1,  there are no  valid subarrays.
- The sliding window expands to the right at each step, and shrinks from the left until the condition is met.
- Once the window satisfies the condition, the number of valid subarrays starting at or after `left` and ending at `right` is `(right - left + 1)`.



## Code/Solution


```java
class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2)return 0;
        
        int l = 0, p = 1, ans = 0;

        for (int r = 0; r < nums.length; r++) {
            p *= nums[r];
            while (p >= k) {
                p /= nums[l++];
            }
            ans += r - l + 1;
        }
        
        return ans;
    }
}
```