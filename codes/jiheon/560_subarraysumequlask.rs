use std::collections::HashMap;

impl Solution {
    pub fn subarray_sum(nums: Vec<i32>, k: i32) -> i32 {
            let mut ans = 0;
            let mut acc = 0;
            let mut map: HashMap<i32, i32> = HashMap::from([(0, 1)]);
            
            for num in nums {
                acc += num;
                let target = acc - k;
                ans += map.get(&target).copied().unwrap_or_default();
                *map.entry(acc).or_insert(0) += 1;
            }

            ans
        }

    // pub fn subarray_sum_fold(nums: Vec<i32>, k: i32) -> i32 {
    //     nums.into_iter()
    //         .fold((0, 0, HashMap::new()), |mut acc, x| {
    //             *acc.2.entry(acc.1).or_insert(0) += 1;
    //             acc.1 += x;
    //             acc.0 += acc.2.get(&(acc.1 - k)).copied().unwrap_or_default();
    //             acc
    //         }).0
    // }
}