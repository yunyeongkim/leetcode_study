impl Solution {  
    pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {  
        let (mut m, mut n) = (m as usize, n as usize);  
  
        for i in (0..nums1.len()).rev() {  
            if n == 0 || (m > 0 && nums1[m - 1] > nums2[n - 1]) {  
                m -= 1;  
                nums1[i] = nums1[m];  
            } else {  
                n -= 1;  
                nums1[i] = nums2[n];  
            }  
        }  
    }  
}