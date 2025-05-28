# [713.SubarrayProductLessThanK](https://leetcode.com/problems/subarray-product-less-than-k/)

## 1. Problem Analysis
Slicing window seemed efficient here. We first need to find a group that contains the maximum number of consecutive elements whose product do not exceed k. Then we count the number of the elements which imply the number of subarrays starting with the first element of that group. 
After counting, we proceed to the next group by sliding the window by setting the next element as the first element of the group. If we repeat this until we reach the last element as the beginning of the group, we get all the subarrays.
For example, a group of `| 10 2 6 |`, the subarrays I get are: `[10]`, `[10, 2]`, `[10, 2, 6]`. Then the next window will be `| 2 6 |`, starting from the element `2`.

```
array: [5, 10, 2, 6]

| 5 |
| 5 10 | => count 2: [5], [5, 10]
  | 10 |
  | 10 2 |
  | 10 2 6 | => count 3: [10], [10, 2], [10, 2, 6]
     | 2 6 | => count 2: [2], [2, 6]
       | 6 | => count 1: [6]
```


## 2. First Code Submission

```python
class Solution(object):
    def numSubarrayProductLessThanK(self, nums, k):
        count = 0
        end = 0
        product = 1
        
        for start in range(len(nums)):
            if end < start:
                end = start
                product = 1

            while end < len(nums):
                if product * nums[end] >= k:
                    count += end - start
                    break

                product *= nums[end]
                end += 1
            else:
                count += end - start

            product /= nums[start]

        return count
```

## 3. First Code Analysis

I iterated the starting element and moved the end element either until the product exceeds k or the end index exceeds the range.
So these two cases should be handled separately.
Moreover, if the element itself exceeds k, the end index might be smaller than the start index causing errors like getting negative counts. For example, if the array is [57, 38, 9] where k is 10, starting index will change from 0 to 1 immediately since the product exceeds k. But the end index didn't get a chance to move, so it remains at 0. So in this case, the end should be reset to the start index.

I immediately came up with the idea when I saw the problem and it seemed rather simple, but my code ended up being messy and hard to follow since I had to handle several edge cases. So it took quite a while to get the code that passes the tests. Maybe I should think about iterating the end element rather than the start element.