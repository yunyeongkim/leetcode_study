use std::collections::HashMap;

impl Solution {
	pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
		let counter = nums
			into_iter()
			.fold(HashMap::new(), |mut map, num| {
				*map.entry(num).or_insert(0) += 1;
				map
			});
	
		let mut v: Vec<(i32, i32)> = counter.into_iter().collect();
		v.sort_unstable_by_key(|x| x.1);
		v.into_iter().rev().take(k as usize).map(|x| x.0).collect()
	}
}