
[problem](https://leetcode.com/problems/subarray-sum-equals-k/)

I solved a similar  problem before, and I found it to be a really interesting algorithmic challenge.

I had solved a similar problem before, and it is one of problems that I think really interesting from an algorithm perpective.


## IDEA
- The most intuitive approach is to calculate all possible subarrays of array `nums` using a double loop, but it takes $O(n^2)$ time complexity.
- So we need a more optimized approach.

## Solution
- Initialize a hash map with {0: 1}. In this map, each key represents a state (prefix sum), and each value represents how many times that state has occurred.
- Iterate through the `nums` array and calculate the accumulated sum up to the current element. We can find the target value using the formula ($`current_sum - k`$)
- If target value exists in hashmap,it means there is a subarray between the previous prefix sum (equal to the target) and the current position that sums to k. So we can add the number of times the target has occurred to the answer.
- After that, we increment the value in the hash map for the current prefix sum - this records the current state.

```rust
use std::collections::HashMap;

impl Solution {
    pub fn subarray_sum(nums: Vec<i32>, k: i32) -> i32 {
            let mut ans = 0;
            let mut acc = 0;
            let mut map: HashMap<i32, i32> = HashMap::from([(0, 1)]);
            
            for num in nums {
                acc += num;
                let target = acc - k;
                ans += map.get(&target).copied().unwrap_or_default();
                *map.entry(acc).or_insert(0) += 1;
            }

            ans
        }

    // pub fn subarray_sum_fold(nums: Vec<i32>, k: i32) -> i32 {
    //     nums.into_iter()
    //         .fold((0, 0, HashMap::new()), |mut acc, x| {
    //             *acc.2.entry(acc.1).or_insert(0) += 1;
    //             acc.1 += x;
    //             acc.0 += acc.2.get(&(acc.1 - k)).copied().unwrap_or_default();
    //             acc
    //         }).0
    // }
}
```