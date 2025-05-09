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