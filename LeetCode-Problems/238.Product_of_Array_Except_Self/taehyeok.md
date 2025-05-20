## IDEA

At each index, we need to calculate the product of all elements except the one at that index.
If we calculate this for each index, it would take O(n^2) time.
But, if we pre-calculate the left and right products, we can solve it in just 2 iterations.
We can store the left product in `left_product` while iterating from left to right, and similarly store the right product in `right_product` while iterating from right to left.
Then we can multiply these products to get the final result for each index.


## Trial

```python
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        result = [1] * len(nums)
        left_product = 1
        right_product = 1
        for i in range(len(nums)):
            result[i] *= left_product
            left_product *= nums[i]
        for i in range(len(nums) - 1, -1, -1):
            result[i] *= right_product
            right_product *= nums[i]
        return result
```


## Time Complexity 
`O(n)`: We traverse the list twice, once from left to right and once from right to left.

## Space Complexity
`O(1)`: We use only a constant extra space for two variables `left_product` and `right_product`.




