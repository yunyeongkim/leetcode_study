use std::collections::HashMap;

impl Solution {
    pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        let mut map: HashMap<i32, i32> = HashMap::new();
        let mut v: Vec<i32> = Vec::new();
        for num in nums2 {
            while let Some(&remain) = v.last() {
                if remain >= num {
                    break;
                }
                map.insert(remain, num);
                v.pop();
            }
            v.push(num);
        }

        nums1.iter().map(|x| map.get(x).copied().unwrap_or(-1)).collect()
    }
}