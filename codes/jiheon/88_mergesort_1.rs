impl Solution {
    pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {
        let (mut m, mut n) = (m as usize, n as usize);
        let mut insert_ptr = nums1.len();
        while n > 0 {
            insert_ptr -= 1;
            if m > 0 && nums1[m - 1] > nums2[n - 1] {
                m -= 1;
                nums1[insert_ptr] = nums1[m];
            } else {
                n -= 1;
                nums1[insert_ptr] = nums2[n];
            }
        }
    }
}