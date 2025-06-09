# [35. Search Insert Position](https://leetcode.com/problems/search-insert-position)

## Problem Analysis
I solved this problem using binary search.<br>
`left` and `right` set the range of the array where the target might exist.
- If `nums[middle] > target` - target doesn't exist at indexes smaller or euqal to `middle`. So `left = middle + 1`.
    <pre>
    [1 3 5 7 9] target = 8
     l   m   r
           l r
</pre>

- If `nums[middle] < target` - target doesn't exist at indexes bigger or equal to `middle`. So `right = middle - 1`.
    <pre>
        [1 3 5 7 9] target = 2
        l    m   r
        l  r
</pre>

## Code

```python
class Solution(object):
    def searchInsert(self, nums, target):
        left = 0
        right = len(nums) - 1

        while left <= right:
            middle = (left + right) // 2
            if target == nums[middle]:
                return middle
            elif target > nums[middle]:
                left = middle + 1
            else:
                right = middle - 1

        return left
```

## Code Analysis
The loop only ends when there's an inversion between left and right; `left > right`.


<pre>
[1 3 5 7 9], target = 8
 l   m   r
       l r
         lr     => target < nums[middle] => right = middle - 1
       r l
</pre>

<pre>
[1 3 5 7 9], target = 2
 l   m   r
 l r
 lr             => target > nums[middle] => left = middle + 1
 r l
</pre>
