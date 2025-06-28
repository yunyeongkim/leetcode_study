

## IDEA


1. Find the maximum length of a contiguous subarray with an equal number of 0s and 1s.
2. I will use prefix sums, If we treat 0s as -1, a prefix sum of 0 indicates that the number of 0s and 1s are equal.
3. Find the same prefix sum, the x-distance between the two points indicates the length of the subarray.


## Trial

```python
class Solution(object):
    def findMaxLength(self, nums):
        sum = 0

        dict = {0:-1}
        max_length = 0

        for index, num in enumerate(nums):
            if num == 1:
                sum += 1
            else:
                sum -= 1
            if sum in dict:
                max_length = max(max_length, index - dict[sum])
            else:
                dict[sum] = index
        return max_length
```



## Time Complexity 
O(n), we traverse the array only once.


## Space Complexity
O(n), we use a dictionary to store the prefix sums and their indices.




