use std::collections::HashSet;

impl Solution {

    fn length_of_longest_substring(s: String) -> i32 {
        let mut set = HashSet::new();
        let s_bytes = s.as_bytes();
        let mut l = 0;
        let mut r = 0;
        let mut ans = 0;
        let n = s_bytes.len();

        while r < n {
            if !set.contains(&s_bytes[r]) {
              // copy
                set.insert(s_bytes[r]);
                r += 1;
                ans = ans.max((r - l) as i32);
            } else {
                set.remove(&s_bytes[l]);
                l += 1;
            }
        }
        ans
    }

}