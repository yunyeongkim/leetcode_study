### Problem
[34. Find First and Last Position of Element in Sorted Array]([https://leetcode.com/problems/search-insert-position](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array)
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
### Solution
1. Perform two modified binary searches
2. One that always moves the right boundary leftward upon seeing target (to find the first occurrence).
3. One that always moves the left boundary rightward upon seeing target (to find the last occurrence).
4. Call this routine twice—once with findFirst = True, once with findFirst = False.
5. The two results give [first_index, last_index].

### Code
```python
class Solution:
    def binary_search(self, nums: List[int], target: int, findFirst: bool) -> int:

        start, end = 0, len(nums) - 1
        result = -1

        while start <= end:
            mid = (start + end) // 2
            if nums[mid] == target:
                result = mid
                if findFirst:
                    end = mid - 1
                else:
                    start = mid + 1
            elif nums[mid] < target:
                start = mid + 1
            else:
                end = mid - 1

        return result

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first_pos = self.binary_search(nums, target, True)
        last_pos  = self.binary_search(nums, target, False)
        return [first_pos, last_pos]
```
