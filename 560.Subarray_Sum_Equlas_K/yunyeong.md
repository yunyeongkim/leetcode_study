> ![question]+
> Given an array of integers `nums` and an integer `k`, return _the total number of subarrays whose sum equals to_ `k`.
> A subarray is a contiguous **non-empty** sequence of elements within an array.

### Definition
- `subarray` vs `subsequence`
- In computer science, a **subarray** refers to a sequence of **contiguous elements** within the original array.  
  This differs from a **subsequence**, which can skip elements but still preserves the order.
	- In actual memory, arrays are stored in **contiguous memory blocks**,  so a **subarray** also refers to a segment of memory that is **contiguously allocated**.

#### Why array stored in contiguous memory?
- To allow **fast and efficient access** by index.
- array's elements sizes are same (ex: int , float)
- Once the **starting memory address** of the array is known,  the memory address of the `i-th` element can be computed directly using the formula:  `address = base_address + i × element_size`
  
ex) C memory model
```c
int arr[5] = {10, 20, 30, 40, 50};
# arr[3] = 0x1000 + 3 × 4 = 0x100C
```

#### contiguous vs continuous?
- continuous memory block -> **X**
- contiguous -> space   /   continuous -> time 
- This refers to being **"physically adjacent" (contiguous)** in space,  not **"uninterrupted over time" (continuous)** in a temporal sense.

### First Code
```python
class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        arr=[]
        for i in range(len(nums)):
            temp =[]
            for j in range(i,len(nums)):
                if nums[j] <= k:
                    temp.append(nums[j])
                    if k == sum(temp):
                        arr.append(temp)
                        break
        return len(arr)

# - was not considered.
```

### Second code
```python
class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        arr=[]
        for i in range(len(nums)):
            temp =[]
            for j in range(i,len(nums)):
                temp.append(nums[j])
                if k == sum(temp):
                    arr.append(temp)
        return len(arr)
# time limit exceeded due to duplicated search. 
```

- I was not paying attention what to return, It doesn't need array to be return, only the counts.

### Third code
```python
class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        count = 0
        for i in range(len(nums)):
            curr_sum = 0
            for j in range(i,len(nums)):
                curr_sum += nums[j]
                if curr_sum == k:
                    count += 1
        return count  
```
### Solution
```

```