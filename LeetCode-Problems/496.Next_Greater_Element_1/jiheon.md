[problem](https://leetcode.com/problems/next-greater-element-i)

## IDEA
- A straightforward solution would be to use a double loop, but its time complexity is $O(n^2)$
- Instead, we can use a monotonic stack which achieves a time complexity of $O(n)$.


## Solution
- Initialize vector to track elements and a hashmap to store the next greater element for each value
- For each element in `nums2` , pop from the stack while the last value is less than the current element and  update hashmap accordingly.
- If no more elements can be popped, push the current element to stack.
- After finishing the iteration over `nums2`, we look up the next greater element for each number in `nums1` using the hashmap and return the result.

```rust
use std::collections::HashMap;

impl Solution {
    pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        let mut map: HashMap<i32, i32> = HashMap::new();
        let mut v: Vec<i32> = Vec::new();
        for num in nums2 {
            while let Some(&remain) = v.last() {
                if remain >= num {
                    break;
                }
                map.insert(remain, num);
                v.pop();
            }
            v.push(num);
        }

        nums1.iter().map(|x| map.get(x).copied().unwrap_or(-1)).collect()
    }
}
```
