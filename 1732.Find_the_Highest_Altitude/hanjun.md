# 1732. Find the Highest Altitude

[problem][https://leetcode.com/problems/find-the-highest-altitude/description/]

### Intuition

To solve this problem we need to track the cumulative altitude after each step and we use `max` method to get the highest altitude.

### Method: One Pass; Time: O(N), Space: O(N)

```python
def largestAltitude(self, gain: List[int]) -> int:
    answer = [0]
    for i in range(len(gain)):
        answer.append(answer[i] + gain[i])
    return max(answer)
```

We start at 0 altitude. And, we know that `altitudes[1] = [0] + gain[0]`. Extending the first formula, we obtain that `altitudes[i+1] = altitudes[i] + gain[i]`.

This method has a time complexity of O(N) since it only takes one pass, which will make the program run much faster when given a very large nums array.

