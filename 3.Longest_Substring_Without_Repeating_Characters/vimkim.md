I was thinking that the above question can be interpreted more generally,
even metaphorically.

For example, imagine we are in a nuclear plant.
If an abnormal event occurs twice, **there's a high probability that we are in danger.**

Therefore, I need to trigger an alarm if the same abnormal event happens more than once.

In this case, using a **set** is the most advisable approach.
I can add each abnormal event to the set as it occurs, and if an event is already in the set,
I know it's a repeat and must trigger an alert.

---

```python
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        set_ = set()

        l = r = 0
        N = len(s)
        ans = 0

        while r < N:
            if s[r] not in set_:
                set_.add(s[r])
                r += 1
                ans = max(ans, r - l) # length of peaceful period 무사고 기간

            else: # dance
                set_.remove(s[l])
                l += 1 # day 1 -> 2 -> 3 ...

                49th 50 - 99

        return ans


```

```go
package main

import "fmt"

func lengthOfLongestSubstring(s string) int {
    set := make(map[byte]bool)
    l, r, ans := 0, 0, 0
    N := len(s)

    for r < N {
        if !set[s[r]] {
            set[s[r]] = true
            r++
            if r - l > ans {
                ans = r - l
            }
        } else {
            delete(set, s[l])
            l++
        }
    }
    return ans
}

```

```rust
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
```
