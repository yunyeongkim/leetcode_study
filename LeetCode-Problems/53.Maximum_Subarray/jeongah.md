# [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/description/)

## Problem Analysis
Some numbers will increase the sum while others won't. More importantly, certain numbers may exceed the current sum on their own. In such cases, the sum should just restart from this large number. Moreover, multiple such occurrences may arise within an array.

## Code

```python
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        cur_sum = 0
        max_sum = -inf

        for num in nums:
            cur_sum += num

            if num > cur_sum:
                cur_sum = num

            max_sum = max(max_sum, cur_sum)
        
        return max_sum
```

## Code Analysis
`cur_sum` is reset anytime there is a number that is greater the current total. Ohterwise, it keeps adding numbers whether they add up the total or not.
So `max_sum` should keep track of the maximum sum that we have encountered so far.

<pre>
[2  -1  4  -1  2  1  -5  4  1  3]
 2   1
        4   3  5  6   1
                         4  5  8
</pre>
