impl Solution {
    pub fn permute(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut res = vec![];
        let mut nums = nums;

        Self::permute_internal(&mut nums, &mut res, 0);

        res
    }

    fn permute_internal(nums: &mut Vec<i32>, res: &mut Vec<Vec<i32>>, depth: usize) {
        if depth == nums.len() {
            res.push(nums.clone());
            return;
        }

        for i in depth..nums.len() {
            // println!("{} {}", i, depth);
            nums.swap(i, depth);
            Self::permute_internal(nums, res, depth + 1);
            nums.swap(i, depth);
        }
    }
}