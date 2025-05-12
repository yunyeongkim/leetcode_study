# 1480. Running Sum of 1d Array

[problem][https://leetcode.com/problems/running-sum-of-1d-array/description/]

### Intuition

To solve this problem we need to create an array that will store the running sum up to that index. 

### Method 1: One Pass; Time: O(N), Space: O(N)

```python
def runningSum(self, nums: List[int]) -> List[int]:
    answer = [nums[0]]
    for i in range(1, len(nums)):
        answer.append(answer[i-1]+nums[i])
    return answer
```

The key insight here is that the **running sum up to index i is the sum of nums[i] and the running sum up to index i-1**. Here is a more detailed explanation:

We know that `runningSum[i] = nums[0] + nums[1] + ... + nums[i-1] + nums[i]`. 

However, `runningSum[i-1] = nums[0] + nums[1] + ... + nums[i-1]`, so we can rewrite the first expression to get that `runningSum[i] = runningSum[i-1] + nums[i]`.

This method has a time complexity of O(N) since it only takes one pass, which will make the program run much faster when given a very large nums array. However, there is still a way to optimize the space we use.

---

I was able to find additional information in this [article][https://leetcode.com/problems/running-sum-of-1d-array/solutions/2635285/comprehensive-python-explanation-4-methods/].

### Method 2: One Pass(In-place algorithm<sup>[1](#footnote_1)</sup>); Time: O(N), Space: O(1)

```python
def runningSum(self, nums: List[int]) -> List[int]:
    for i in range(1,len(nums)):
        nums[i] = nums[i-1] + nums[i]						# nums[0] is same as runningSum[0]
    return nums
```

This method uses the same insight as Method 1 but does it without using an extra array to store the result. If we are currently at index i, we can assume `nums[i-1], nums[i-2], ... , nums[0]` have all been visited before and therefore contain the running sum up to that point. This means that `nums[i-1]` is actually the same as `runningSum[i-1]` in the last method! By modifying nums in-place and **not using an extra array that shows the runningSum**, we cut down on any unnecessary extra space.

<span style="font-size:70%"><a name="footnote_1">1</a>: **in-place algorithm** is an algorithm that operates directly on the input data structure without requiring extra space proportional to the input size.</span> 
