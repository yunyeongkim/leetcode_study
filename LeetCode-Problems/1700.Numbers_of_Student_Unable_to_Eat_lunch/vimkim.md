```rust
struct Solution;
use std::collections::VecDeque;

impl Solution {
    pub fn count_students(students: Vec<i32>, sandwiches: Vec<i32>) -> i32 {
        let mut q: VecDeque<i32> = students.into();
        let mut i = 0;
        let len = sandwiches.len();
        let mut rotation = 0;

        while i < len {
            if q.front() == Some(&sandwiches[i]) {
                q.pop_front();
                i += 1;
                rotation = 0;
            } else {
                let student = q.pop_front().unwrap();
                q.push_back(student);
                rotation += 1;
                if rotation == q.len() {
                    break;
                }
            }
        }

        (len - i) as i32
    }
}

fn main() {
    let x = Solution::count_students(vec![1, 1, 0, 0], vec![0, 1, 0, 1]);
    assert_eq!(x, 0);
    let x = Solution::count_students(vec![1, 1, 1, 0, 0, 1], vec![1, 0, 0, 0, 1, 1]);
    assert_eq!(x, 3);
}

```
