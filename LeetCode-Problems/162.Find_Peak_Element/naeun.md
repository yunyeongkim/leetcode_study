- Couldn't solve

# Answer
```java
class Solution {
    public int findPeakElement(int[] nums) {
        // left < mid > right
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[mid+1]){
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }
}
```

## Thought Flow
- logN -> consider binary search
- target condition: `nums[mid-1] < nums[mid] > nums[mid+1]`
- until before left == right
    - if(nums[mid] > nums[mid+1]) -> move right to mid
    - else (mid[mid] <= nums[mid+1]) -> means increasing so that move left to mid
