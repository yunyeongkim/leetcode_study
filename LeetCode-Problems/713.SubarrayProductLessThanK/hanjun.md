[713.Subarray_Product_Less_than_K][https://leetcode.com/problems/subarray-product-less-than-k/description/]

### Intuition

We can use a sliding window that arranges the product from left to right. And if the product more than k, we should divide the first left element.

About index i that is right index, we can count the number of subarray in nums[left:right+1]. So we can use formula "right - left + 1". 



### Method: Sliding Window&two pointer;Time: O(N)

```python
class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k<=1:
            return 0

        prod = 1
        count = 0
        left = 0
        
        for right in range(len(nums)):
            prod *= nums[right]
            while prod>=k:
                prod //= nums[left]
                left += 1
            count += right - left + 1
        
        return count
```



