
[question](https://leetcode.com/problems/maximum-average-subarray-i)

## IDEA
If we use a two-dimensional loop to calculate the sum of all elements, it will take $O(n^2)$ time.
So we have too use 'sliding windows' to solve this problem.

## First Code/Solution

1. Initalize the window (sum) with first the `k` elements
2. Move the window to the right one elements at a time and calculate the maxium sum value.

```rust
impl Solution {
    pub fn find_max_average(nums: Vec<i32>, k: i32) -> f64 {
        let k = k as usize;
        let mut max_sum: i32 = nums.iter().take(k).sum();
        let mut tmp_sum = max_sum;
        for i in k..nums.len() {
            tmp_sum = tmp_sum + nums[i] - nums[i - k];
            max_sum = max_sum.max(tmp_sum);
        }
        max_sum as f64 / k as f64
    }
}
```