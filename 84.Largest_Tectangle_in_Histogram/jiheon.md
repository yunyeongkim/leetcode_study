
[problem](https://leetcode.com/problems/largest-rectangle-in-histogram/)


I had a feeling that this problem required a monotonic-stack approach to solve.
However, this problem was too difficult for me to solve--I couldn't figure out how to determine the starting point of a rectangle , so I had to use GPT to get a hint.



## IDEA
-  Maintain a stack in ascending order while iterating through the `heights`.
-  While the stack needs to be popped, calculate the area of popped elements.

## Solution/First code

- The stack stores the indices of the prev heights.
- Pop from the stack while height at the top of the stack is greater than or equal to the current height, and calculate the area using the popped height.
    - Because the stack is in ascending order, we can see that the right boundary of the popped height is `current index - 1`.
    - We can also find that the left boundary of the popped height is `top of the stack + 1`. Because the stack is in ascending order, top of the stack must be smaller than the popped height. So we can derive the formula : `width = i-popped_idx+1`
    * If the stack is empty, the left boundary must start from 0.
- Once we've finished iterating through heights, calculate the area of the remaining elements in the stack using the same formula.


```rust
impl Solution {
    pub fn largest_rectangle_area(heights: Vec<i32>) -> i32 {
        let mut stack: Vec<usize> = Vec::new();
        let mut ans: i32 = 0;
        let n = heights.len();
        for (i, current_height) in heights.iter().enumerate() {
            while matches!(stack.last(), Some(ele) if heights[*ele] > *current_height) {
                let prev_largest_idx = stack.pop().unwrap();
                let height = heights[prev_largest_idx];
                let width = if stack.is_empty() {
                    i
                } else {
                    i - stack.last().unwrap() - 1
                } as i32;
                ans = ans.max(width * height);
            }
            stack.push(i);
        }

        while let Some(prev_largest_idx) = stack.pop() {
            let height = heights[prev_largest_idx];
            let width = if stack.is_empty() {
                n
            } else {
                n - stack.last().unwrap() - 1
            } as i32;
            ans = ans.max(width * height);
        }

        ans
    }
}
```

### More elegant solution

- If we add the minimal height at the end of the `heights`, we don't need to manually process the remaining elements of the stack because all valid heights will be popped at the end.

```rust
impl Solution {
    pub fn largest_rectangle_area(heights: Vec<i32>) -> i32 {
        let mut stack: Vec<usize> = Vec::new();
        let mut ans: i32 = 0;
        for (i, current_height) in heights.iter().chain(std::iter::once(&0)).enumerate() {
            while matches!(stack.last(), Some(ele) if heights[*ele] > *current_height) {
                let prev_largest_idx = stack.pop().unwrap();
                let height = heights[prev_largest_idx];
                let width = if stack.is_empty() {
                    i
                } else {
                    i - stack.last().unwrap() - 1
                } as i32;
                ans = ans.max(width * height);
            }
            stack.push(i);
        }
        ans
    }
}
```