[238.Product_of_array_Except_Self][https://leetcode.com/problems/product-of-array-except-self/description/]

### Intuition

not to use division operation. So we, product left product and right product of index i. If i is 2, we need to product the left index 0 to 1 and right index 3 to n. For example, nums = [1, 2, 3, 4] and i is 2. left product is 1*2, right product is 4. so the output[2] is left * right that is 8.



### Method: Prefix&Suffix Products; Time: O(N)

```python
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        output = [1] * n

        for i in range(1, n):
            output[i] = output[i-1] * nums[i-1]
        
        right = 1
        for i in reversed(range(n)):
            output[i] *= right
            right *= nums[i]
        
        return output
```

We need to optimize space, so we can compute left in-place in output[], and calculate right on the fly using a running product.
