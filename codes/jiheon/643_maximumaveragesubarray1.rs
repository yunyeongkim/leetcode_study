impl Solution {
    pub fn find_max_average(nums: Vec<i32>, k: i32) -> f64 {
        let k = k as usize;
        let mut max_sum: i32 = nums.iter().take(k).sum();
        let mut tmp_sum = max_sum;
        for i in k..nums.len() {
            tmp_sum = tmp_sum + nums[i] - nums[i - k];
            max_sum = max_sum.max(tmp_sum);
        }
        max_sum as f64 / k as f64
    }
}