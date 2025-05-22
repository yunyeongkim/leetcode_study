# [70.Climbing_stairs](https://leetcode.com/problems/climbing-stairs/)

## 1. Problem Analysis
Every number of ways to reach `n` steps is the sum of reaching `n - 1` steps and `n - 2` steps. (Except for the beginnging steps)
So distinct ways to take `n - 1` and `n - 2` steps should be calculated first.
This brings us to the beginning, number of ways to take the irst step. And every number of ways will be counted followingly.
Since I am adding up the numbers for eaching `n - 1` and `n - 2` steps, I need the number of reaching 0 step to get the number for `n = 2`. This which will be initialized to 1 for simmplicity.

## 2. First Code Submission

```python
class Solution(object):
    def climbStairs(self, n):
        steps = {}
        
        for num in range(n + 1):
            if num == 0 or num == 1:
                steps[num] = 1
                continue

            steps[num] = steps[num - 1] + steps[num - 2]
        
        return steps[n]
```

## 3. First Code Analysis

Since I iterate `n + 1` numbers, the time complexity is `O(n)`.
I used a dictionary, but the same can be done with an array.
Array actually seems faster and more efficient here because it can directly save and look up the value at a certain index while a dictionary has to save both keys and values, and need to use keys to find values in a hash map.

## 4. Optimized Solution

```python
class Solution(object):
    def climbStairs(self, n):
        steps = [1 for i in range(n + 1)]
        
        for num in range(n + 1):
            if num == 0 or num == 1:
                steps[num] = 1
                continue

            steps[num] = steps[num - 1] + steps[num - 2]
        
        return steps[n]
```

