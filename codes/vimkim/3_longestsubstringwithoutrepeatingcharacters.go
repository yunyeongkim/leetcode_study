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