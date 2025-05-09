impl Solution {
    pub fn min_sub_array_len(target: i32, nums: Vec<i32>) -> i32 {
        let mut left = 0usize;
        let mut sum = 0;
        let mut ans = usize::MAX;

        for (i, num) in nums.iter().enumerate() {
            sum += num;

            while sum - nums[left] >= target {
                sum -= nums[left];
                left += 1;
            }

            if sum >= target {
                ans = ans.min(i - left + 1);
            }
        }

        if ans == usize::MAX {
            0
        } else {
            ans as _
        }
    }
}