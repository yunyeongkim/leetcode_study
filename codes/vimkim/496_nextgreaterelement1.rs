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