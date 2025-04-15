# 739. Daily temperatures

[problem][][https://leetcode.com/problems/daily-temperatures/description/]

### Intuition

To solve this problem, we need to find the number of days until a warmer temperature appears. We process each temperature once and use a stack to keep track of previous temperatures that haven't yet found a warmer day.



### Method: Time: Monotonic Stack;Time: O(N)

```python
def dailyTemperatures(self, temperatures:List[int])->List[int]:
    stack = []
    answer = [0]*len(temperature)
    for i, temperature in enumerate(temperatures):
        while stack and temperatures[stack[-1]] < temperature:
            day = stack.pop()
            answer[day] = i - day
		stack.append(i)
        
    return answer
```

1.   If the current temperature is greater than the temperature which index at the stack's top, we found a warmer day.
2.   Keep appending indices to the stack until we find a temperature greater than or equal to the current one.
3.   The difference of indices gives the number of days to wait for a warmer temperature.