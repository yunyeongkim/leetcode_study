[problem](https://leetcode.com/problems/find-peak-element)

## IDEA
- If a problem requries $O(\log_n)$ time complexity, It's binary serach.


## SOLUTION/CODE
- Compare `nums[mid]` and `nums[mid+1]`
	- If `nums[mid]` is less than `nums[mid + 1]`, it means there must be a peak on the right side.
	- Else, it means that might be a peak on left side. (`mid` can be a peak itself)

```java
class Solution {
    public int findPeakElement(int[] nums) {
        int l =0, r=nums.length-1, mid=0;

        while (l < r){
            mid = (l+r)/2;

            if(nums[mid] < nums[mid+1]){
                l = mid+1;
            }else{
                r = mid;
            }
        }

        return l;
    }
}
```