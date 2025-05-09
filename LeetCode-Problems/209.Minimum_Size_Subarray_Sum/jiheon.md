
[problem](https://leetcode.com/problems/minimum-size-subarray-sum/description/)

## IDEA
- We can reduce the time complexity to $O(n)$ if we use sliding window approach. (each element is processed at most twice).
- The problem requires us to return 0 if we can't meet the condition for the  entire array, So we need to consider this case.



## Solution
1. Expand the sliding window to the right until the condition is met. (`sum(sliding_window) ≥ target`)
2. Shrink the sliding window from the left while the condition holds. (only shrink if the condition holds after shrinking).
3. Update the answer with minimum  value `right-left+1` if the condition holds.
4. The answer is initialized with `usize::MAX`($2^64-1$). If this value remains unchanged until the end, it means there is no valid subarray.


```rust
impl Solution {
    pub fn min_sub_array_len(target: i32, nums: Vec<i32>) -> i32 {
        let mut left = 0usize;
        let mut sum = 0;
        let mut ans = usize::MAX;

        for (i, num) in nums.iter().enumerate() {
            sum += num;

            while sum - nums[left] >= target {
                sum -= nums[left];
                left += 1;
            }

            if sum >= target {
                ans = ans.min(i - left + 1);
            }
        }

        if ans == usize::MAX {
            0
        } else {
            ans as _
        }
    }
}
```