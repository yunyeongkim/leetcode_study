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