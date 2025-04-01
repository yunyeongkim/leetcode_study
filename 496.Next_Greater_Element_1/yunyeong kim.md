
> [!question]+
> The **next greater element** of some element `x` in an array is the **first greater** element that is **to the right** of `x` in the same array.
> 
> You are given two **distinct 0-indexed** integer arrays `nums1` and `nums2`, where `nums1` is a subset of `nums2`.
> 
> For each `0 <= i < nums1.length`, find the index `j` such that `nums1[i] == nums2[j]` and determine the **next greater element** of `nums2[j]` in `nums2`. If there is no next greater element, then the answer for this query is `-1`.
> 
> Return _an array_ `ans` _of length_ `nums1.length` _such that_ `ans[i]` _is the **next greater element** as described above._

### Definition
- The **next greater element** of some element `x` in an array is the **first greater** element that is **to the right** of `x` in the same array.
	- [4,2,5,2,6] 
	- `x = 5` -> **next greater element**= 6
	  
- You are given two **distinct 0-indexed** integer arrays `nums1` and `nums2`, where `nums1` is a subset of `nums2`.
	- `nums2` is the full array
	- `num1` is alway exist in `nums2`

- For each `0 <= i < nums1.length`, find the index `j` such that `nums1[i] == nums2[j]` and determine the **next greater element** of `nums2[j]` in `nums2`. If there is no next greater element, then the answer for this query is `-1`.
	- With `num1`'s element `num1[j]` , find equal from `num2[j]`
	- Find  **next greater element**  , if not exist set as `-1`

### Definition with example

This type of **Next Greater Element (NGE)** is used for **post-analysis**, not real-time alerting.
#### ❓ Q. Why `nums1` is not ordered like timeline?

Because `nums1` represents **alert-triggered moments** —  
collected and stored **separately from the raw timeline** (`nums2`).

> It doesn't need to follow time order,  
> because we use `nums2` to look up the actual order.

### ⚙️ Monitoring CPU Usage Scenario

Let’s say we have a CPU monitoring system.

- An **alert** is triggered when CPU usage exceeds **30%**.
- Each 10 seconds, the CPU usage is recorded.

```python
nums2 = [10, 40, 20, 35, 70, 50]  # Full CPU usage timeline (in order)
nums1 = [35, 50, 70, 40]          # CPU values when alerts were triggered
```

### 📊 Time Table

| Time | CPU Usage |
| ---- | --------- |
| T1   | 10        |
| T2   | 40        |
| T3   | 20        |
| T4   | 35        |
| T5   | 70        |
| T6   | 50        |

![[image-2 1.png]]


### First Code
```python
class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:

        num1Idx = {n:i for i,n in enumerate(nums1)}
        res = [-1] * len(nums1)
        for i in range(len(nums2)):
            if nums2[i] not in num1Idx: 
                continue
            for j in range(i + 1, len(nums2)):
                if nums2[j] > nums2[i]:
                    idx = num1Idx[nums2[i]]
                    res[idx] = nums2[j]
                    break
        return res

# O(Len(Nums1)+Len(Nums2)) 42.59%
```

```python
class Solution:

    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        num1Idx = {n:i for i,n in enumerate(nums1)}
        res = [-1] * len(nums1)
        stack = []

        for i in range(len(nums2)):
            cur = nums2[i]
            while stack and cur > stack[-1]:
                val = stack.pop()
                idx = num1Idx[val]
                res[idx] = cur 
            if cur in num1Idx:
                stack.append(cur)
        return res

# 52% 
```

