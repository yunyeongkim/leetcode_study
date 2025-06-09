[problem](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

## IDEA
- Just use binary search twice - once to find the lower bound, and once to find the upper bound.



## code/solution
- If the lower bound doesn't exist, the upper bound doesn't either.
- When lower bound exists, we can start the upper bound search from that index. (This isn't significantly faster, but it can help in practice.)

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0,r=nums.length-1,mid=0;
        int[] answer = {-1,-1};
        if (r == -1) return answer;
        //lower bound
        while (l<=r){
            mid = (l+r)/2;
            if (nums[mid] < target){
                l = mid+1;
            }else{
                r = mid -1;
            }
        }

        if (l >=nums.length || nums[l] != target){
            return  answer;
        }else{
            answer[0] = l;
        }

        r = nums.length-1;

        //upper bound
        while (l<=r){
            mid = (l+r) /2;
            if (nums[mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        answer[1] =r ;

        return answer;
    }
}
```
