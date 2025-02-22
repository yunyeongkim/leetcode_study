[question](https://leetcode.com/problems/merge-sorted-array/description/)

## Idea
> 1. Sorting requires $O(n \log n)$, so  should use it!
> 2. The first $m$  elments of nums1 already filled, so we can't start merging from beginning



## First code

- Start filling the elements at the end of `nums`1 
- Use two pointers :  one for `nums1`,and  one for `nums2`. each pointing to the last element.
- if both `nums1` and `nums2` has elements, compare the last element and place larger one. (also decrease pointer)
- if one array is not exhausted, only use another remaining array until the beginning.

> I should  to use `[m-1]` to prevent *underflow*

```rust
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
```

## More elegance

- if `nums2` is exhausted, we do not need to continue because `nums1` already contains the remaining elements in correct order!.

```rust
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
```