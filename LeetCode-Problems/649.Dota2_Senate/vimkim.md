```rust
use std::collections::VecDeque;
struct Solution;

impl Solution {
    pub fn predict_party_victory(senate: String) -> String {
        let mut r_cnt = 0;
        let mut d_cnt = 0;
        let mut rotation = 0;
        let mut q: VecDeque<u8> = senate.chars().map(|c| c as u8).collect();
        // dbg!(&q);

        while let Some(c) = q.pop_front() {
            // dbg!(&q);
            if rotation == q.len() + 1 {
                break;
            }
            if c == b'R' {
                if d_cnt > 0 {
                    d_cnt -= 1;
                    rotation = 0;
                } else {
                    r_cnt += 1;
                    q.push_back(c);
                    rotation += 1;
                }
            } else if c == b'D' {
                if r_cnt > 0 {
                    r_cnt -= 1;
                    rotation = 0;
                } else {
                    d_cnt += 1;
                    q.push_back(c);
                    rotation += 1;
                }
            } else {
                unreachable!();
            }
        }

        if r_cnt > 0 {
            "Radiant".to_string()
        } else {
            "Dire".to_string()
        }
    }
}

fn main() {
    let input = "R";
    let output = Solution::predict_party_victory(input.to_string());
    assert_eq!(output, "Radiant".to_string());

    let input = "RD";
    let output = Solution::predict_party_victory(input.to_string());
    assert_eq!(output, "Radiant".to_string());

    let input = "RDD";
    let output = Solution::predict_party_victory(input.to_string());
    assert_eq!(output, "Dire".to_string());

    println!("All tests passed!");
}

```
