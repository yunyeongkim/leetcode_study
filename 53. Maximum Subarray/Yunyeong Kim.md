> [!question]
> Given an integer array `nums`, find the subarray with the largest sum, and return _its sum_.
> > [!example]
> > Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
>>
Example 2:
>>Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
>>
Example 3:
>> Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

> [!note] Constraints
> - `1 <= nums.length <= 105`
  `-104 <= nums[i] <= 104`

### Definition
- A subarray is any contiguous sequence of elements within an array.
- The length of a subarray must satisfy: `1 ≤ subarray length ≤ len(array)`.
- 배열 `nums = [1, 2, 3, 4, 5]`일 때, 가능한 Subarray:

|길이|가능한 Subarrays|
|---|---|
|1|`[1]`, `[2]`, `[3]`, `[4]`, `[5]`|
|2|`[1,2]`, `[2,3]`, `[3,4]`, `[4,5]`|
|3|`[1,2,3]`, `[2,3,4]`, `[3,4,5]`|
|4|`[1,2,3,4]`, `[2,3,4,5]`|
|5|`[1,2,3,4,5]` (전체 배열)|
### First Code / 30 min
```python
class Solution:
    def maxSubArray(self, nums: list[int]) -> int:

        def __sub_function(i , current_sum, max_sum):
            if i == len(nums):
                return max_sum
            
            current_sum += nums[i]
            max_sum= max(max_sum, current_sum)
            print(f"i= {i} ,current ={current_sum} , max ={max_sum}")

            if current_sum < 0 :
                current_sum = 0
            return __sub_function(i+1,current_sum,max_sum)
        
        return __sub_function(0,0,nums[0])
# Output Limit Exceeded.
```
### First Code explain
![[Maximum_array_first.excalidraw]]
- My solution is also O(n), but it uses unnecessary stack space, causing a time limit exceeded error.
- Only the max_sum result is needed, but I overcomplicated the process
- I didn't focus on the core logic for obtaining the result

### Solution
```python
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:            
        res = nums[0]  # 최댓값 저장 (초기값: 첫 번째 요소)
        total = 0  # 현재까지의 합

        for n in nums:
            if total < 0:
                total = 0  # 음수라면 리셋 (새로운 부분 배열 시작)

            total += n  # 현재 숫자를 더함
            res = max(res, total)  # 최댓값 갱신
        
        return res
```
![[Maximum_subarray_sol.excalidraw]]

