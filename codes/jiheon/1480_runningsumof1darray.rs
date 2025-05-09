impl Solution {
    pub fn running_sum(nums: Vec<i32>) -> Vec<i32> {
        nums.iter()
            .fold((Vec::with_capacity(nums.len()), 0), |mut acc, x| {
                acc.1 += x;
                acc.0.push(acc.1);
                acc
            }).0
    }
}