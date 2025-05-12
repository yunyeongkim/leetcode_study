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