 > [!question]+
> Given an array `nums` of size `n`, return *the majority element*.  
> The majority element is the element that appears more than `⌊n / 2⌋` times.  
> You may assume that the majority element always exists in the array.
> > [!example]+ Example 1
> **Input:** `nums = [3, 2, 3]`  
> **Output:** `3`
> 
>> [!example]+ Example 2
> **Input:** `nums = [2, 2, 1, 1, 1, 2, 2]`  
> **Output:** `2`

> [!note] Definition
> 1. Majority element always exist in the array.
> 2. Appears more than **⌊n / 2⌋** times
> 	1.  If size = 5 / it should appear more than 5/2 times -> 2
> 	2. **⌊ ⌋**   represents **바닥 함수(Floor function)**
> 3. Only one element should be returned.

### First Code : 10 min
```python
class Solution(object):
    def majorityElement(self, nums):
        flag = int(len(nums)/2)
        counter = {}
        for num in nums:
            if num in counter:
                counter[num] += 1
            else:
                counter[num] = 1
            if counter[num] > flag:
                return num
        return None
# O(n) / O(n)
```

### Solution 
```python
# Boyer-Moore Voting Algorithm
class Solution(object):
    def majorityElement(self, nums):
        count=0
        number=None
        for num in nums:
            if count==0:
                number=num
            if num==number:
                count+=1
            else:
                count-=1
        return number
# O(n) /  O(1) space complexticy
```

### Solution Explain
- Since the **"majority element"** is guaranteed to exist, 
  there is no need to check when an element surpasses the majority threshold during the array traversal. 
  For example, the **Boyer-Moore Voting Algorithm** also returns the **candidate** without verifying if it actually exceeds the majority count.

![[169_Majority_code_first.excalidraw]]

