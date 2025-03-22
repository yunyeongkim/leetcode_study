> [!question]+
> You are given an integer array `nums` consisting of `n` elements, and an integer `k`.
Find a contiguous subarray whose **length is equal to** `k` that has the maximum average value and return _this value_. Any answer with a calculation error less than `10^-5` will be accepted.
>> [!example]+
>> Input: nums = [1,12,-5,-6,50,3], k = 4
>> Output: 12.75000
>> Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
>
>>[!example]+
>>Input: nums = [5], k = 1
Output: 5.00000

### Definition
- contiguous subarray whose length is equal to k 
	- [0,1,2,3,4,5] 
	- if k = 2
	- [0,1] \ [1,2] \ [2,3] ...
- contiguous subarray should have maximum average value.
	- [0,1] \ [1,2] \ [2,3] ...\ [4,5]
	- 0.5 / 1.5 / 2.5 / 4.5 
	- -> [4 ,5] has  maximum average value.
- return average value 
	- [4,5] -> 4.5 -> return 4.5
- A difference smaller than 0.00001 (up to 5 decimal places) is acceptable.

### Cases
```yml
base_cases:
  - case: "base case (n = 1, k = 1)"
	    nums: [1]
	    k: 1

edge_cases:
  - case: "k == n"
	    nums: [1, 2, 3, 4, 5]
	    k: 5

  - case: "k == 1 (find max element)"
	    nums: [-3, -5, -2, -8]
	    k: 1

  - case: "equal averages in all subarrays"
	    nums: [-1, -1, -1, -1]
	    k: 2

```

### First Code
```python
class Solution:
    def findMaxAverage(self, nums: list[int], k: int) -> float:
        max_avg = min(nums)
        for i in range(0, len(nums) - k + 1 ):
            window = nums[i:i + k]
            avg = sum(window) / k 
            if max_avg < avg:
                max_avg = avg
        return round(max_avg, 5) 
# Time Limit exceeded.
```


### Solution
#### First
```python
class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        # Initialize currSum and maxSum to the sum of the initial k elements
        currSum = maxSum = sum(nums[:k])

        # Start the loop from the kth element 
        # Iterate until you reach the end
        for i in range(k, len(nums)):

            # Subtract the left element of the window
            # Add the right element of the window
            currSum += nums[i] - nums[i - k]
            
            # Update the max
            maxSum = max(maxSum, currSum)

        # Since the problem requires average, we return the average
        return maxSum / k
```

#### Second
```python
class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        n = len(nums)
        windowSum = sum(nums[:k])
        maxSum = windowSum
        
        for i in range(k, n):
            windowSum += nums[i] - nums[i - k]
            maxSum = max(maxSum, windowSum)
            
        return maxSum / k     
```

### What is different? 
- **Sliding window** is a technique that leverages previous results to avoid recalculating the entire sum for every subarray.  
  Instead, it moves one step at a time, updating the cumulative sum efficiently.  
  That’s why we only need to compute the first window once, and then start from `i = k`.

#### example
```
nums = [1, 3, 2, 6, -1, 4, 1, 8, 2]
k = 3
```
1. First Window `i=0`
```yaml
[1, 3, 2] 6  -1  4  1  8  2
                    ↑  ↑  ↑
# currSum = 1 + 3 + 2 = 6
```
2. Slide right by 1 `i=3`
```yaml
 1 [3, 2, 6] -1  4  1  8  2
    ↑  ↑  ↑(i)
# nums[i] - nums[i - k] -
# nums[i] = 6 ; nums[i - k][(3-3)] -> nums[0] = 1
# currSum = prevSum + 6 (new window) - 1 (passed window value)
#        = 11
```
3. Slide right by 1 `i=4`
```yaml
 1  3 [2, 6, -1] 4  1  8  2
       ↑  ↑   ↑
# currSum = 11 + (-1) - 3 = 7
```
