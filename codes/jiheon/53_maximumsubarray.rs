use std::cmp::max;
impl Solution {
	pub fn max_sub_array(nums: Vec<i32>) -> i32{
	 nums.iter().skip(1)
		 .fold((nums[0], nums[0]), |mut acc, num| {
			  acc.0 = max(acc.0 + num, *num); //sum
			  acc.1 = max(acc.0, acc.1); //maximum sum
			  acc }
			).1 
  }
}