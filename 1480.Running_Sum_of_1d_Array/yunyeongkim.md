> [!question]+
> Given an array `nums`. We define a running sum of an array as `runningSum[i] = sum(nums[0]…nums[i])`.
> Return the running sum of `nums`.
>
> >[!example]+
> >**Input:** nums = [1,2,3,4]
> >**Output:** [1,3,6,10]
> >**Explanation:** Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

### Definition
- `Running sum` = `Prefix Sum` = `Cumulative Sum`
- cumulative`[│kjuːmjəleɪtɪv]` 
	- You need to keep a `running sum` here 
	- `running total` example in sql 
	- How to get the `cumulative` `running total` of rows with SQL (Oracle)

- First is always remains same. (first do not need to calculate)

### First Code
```python
class Solution:
    def runningSum(self, nums: list[int]) -> list[int]:
        arr = []
        arr.append(nums[0])
        for i in range(1,len(nums)):
            arr.append(arr[i-1]+nums[i])
        return arr
# O(n)
```

###  O(1)
```python
class Solution:
    def runningSum(self, nums: list[int]) -> list[int]:
        for i in range(1, len(nums)):
            nums[i] += nums[i - 1]
        return nums

```