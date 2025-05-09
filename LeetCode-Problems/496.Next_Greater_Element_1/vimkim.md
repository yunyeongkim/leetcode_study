# 496. Next Greater Element I

```rust

impl Solution {
    pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        use std::collections::HashMap;
        let mut next = HashMap::new();
        let mut stack = Vec::new();


        for &num in &nums2 {
            while let Some(&last) = stack.last() {
                if num > last {
                    next.insert(last, num);
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(num);
        }

        // For elements without a greater element to their right, use -1
        nums1.into_iter()
            .map(|num| *next.get(&num).unwrap_or(&-1))
            .collect()
    }
}
```

![image](https://github.com/user-attachments/assets/1e3b39fc-9ce9-4a5d-a94a-2d6a075a38e1)


Imagine each number in the array represents the height of a building, with people standing on each rooftop, one person per building. Each person is looking toward the right (the direction of increasing indices in the array).

For each person:
- If they can see another building, it will be the first building to their right that is taller than their own building
- The "next greater element" is the height of that first taller building they can see
- If there are no taller buildings to their right, they can't see any building, and we represent this with -1

This is exactly what the algorithm does:
1. It uses a stack to keep track of buildings (numbers) that haven't found their "next greater element" yet
2. For each new building, it checks if it's taller than any previous buildings in the stack
3. If it is taller, those previous buildings have found their "next greater element"
4. Finally, any building still in the stack at the end can't see a taller building, so their "next greater element" is -1
