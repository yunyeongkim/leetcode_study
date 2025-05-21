## IDEA

At each index, we need to calculate the product of all elements except the one at that index.
If we calculate this for each index, it would take O(n^2) time.
But, if we pre-calculate the left and right products, we can solve it in just 2 iterations.
We can store the left product in `left_product` while iterating from left to right, and similarly store the right product in `right_product` while iterating from right to left.
Then we can multiply these products to get the final result for each index.

## Simulation
nums = [3, 5, 7]

### Left Product Calculation

#### index = 0
```
[3, 5, 7]
 ↑
 
left_product = 1
[1, 1, 1] result[0] *= left_product = 1
 ↑
left_product *= nums[0] = 3

```
#### index = 1
```
[3, 5, 7]
    ↑
    
left_product = 3
[1, 3, 1] result[1] *= left_product = 3
    ↑
left_product *= nums[1] = 3 * 5 = 15
```
#### index = 2
```
[3, 5, 7]
       ↑
       
left_product = 3 * 5
[1, 3, 15] result[2] *= left_product = 15
       ↑
```

### Right Product Calculation
#### index = 2
```
[3, 5, 7]
       ↑
       
right_product = 1
[1, 3, 15] result[2] *= right_product = 1
       ↑
right_product *= nums[2] = 7
```
#### index = 1
```
[3, 5, 7]
    ↑
    
right_product = 7
[1, 21, 15] result[1] *= right_product = 7
    ↑

right_product *= nums[1] = 7 * 5 = 35
```

#### index = 0
```
[3, 5, 7]
 ↑
 
right_product = 7 * 5
[35, 21, 15] result[0] *= right_product = 35
 ↑
 ```


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




