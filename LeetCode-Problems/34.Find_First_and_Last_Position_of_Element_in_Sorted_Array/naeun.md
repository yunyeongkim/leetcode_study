- failed to solve..

# Solution
- [question](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/)

- TimeComplexity : O(logN)
- space : O(1)

- I failed to solve so that I requested gpt to improve my code to address the problem.

## Points that I missed
- in binary search I could update `mid = left + (right - left) / 2;`
- move left or right with mid +-1 <= if use same mid, it might not be finished.
    - `nums[mid] < target` -> `left = mid+1`
    - `nums[mid] > target` -> `right = mid-1`
- separate field of resultIndex and movingIndex(left, right).
- keep search binary even though you found the target.
## code
```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = binarySearchLeft(nums, target);
        result[1] = binarySearchRight(nums, target);
        return result;
    }

    private int binarySearchLeft(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                result = mid;
                right = mid - 1; // 더 왼쪽에 있는 target을 찾기 위해
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private int binarySearchRight(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                result = mid;
                left = mid + 1; // 더 오른쪽에 있는 target을 찾기 위해
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
```

## other's code
- could use same private methods with a boolean parameter.
```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        result[0] = left;
        result[1] = right;
        return result;        
    }

    private int binarySearch(int[] nums, int target, boolean isSearchingLeft) {
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                idx = mid;
                if (isSearchingLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return idx;
    }

}
```