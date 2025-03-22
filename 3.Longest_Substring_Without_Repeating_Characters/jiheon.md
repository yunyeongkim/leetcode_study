
[problem](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

## IDEA
- If we use a brute-force algorithm, It will take $O(50000)^3$ time.
- So we have to use the sliding window approach, It only takes $O(n)$ time.



## Solution
- If the current window meets the condition (each element must appears only once), increase the window
and if it doesn't, shrink it until it meets the condition. In this approach, each element is processed at most twice.
- To check the duplication of element, use `set`


```rust
use std::char;
use std::collections::HashSet;

impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        let s: Vec<char> = s.chars().collect();
        let mut ans = 0;
        let mut left = 0usize;
        let mut set: HashSet<char> = HashSet::new();

        for (i, c) in s.iter().enumerate() {
            if !set.insert(*c) { // fn HashSet.insert(c) returns true if c was not present in set before inserting it.
                while s[left] != *c {
                    set.remove(&s[left]);
                    left += 1;
                }
                left += 1;
            } else {
                ans = ans.max(i - left + 1);
            }
        }

        ans as _
    }
}
````