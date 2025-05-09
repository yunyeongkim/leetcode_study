
[problem](https://leetcode.com/problems/find-the-highest-altitude/)


First code/Solution
- Calculate the accumulated altitude and update the global maximum while iterating through `gain`
```rust
impl Solution {
    pub fn largest_altitude(gain: Vec<i32>) -> i32 {
        gain.into_iter()
            .fold((0,0),|mut acc, x| {
                acc.0 += x;
                acc.1 = acc.1.max(acc.0);
                acc
            }).1
    }   
}
```