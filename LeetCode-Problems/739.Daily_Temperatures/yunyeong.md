> [!question]+
> Given an array of integers `temperatures` represents the daily temperatures, return _an array_ `answer` _such that_ `answer[i]` _is the number of days you have to wait after the_ `ith` _day to get a warmer temperature_. If there is no future day for which this is possible, keep `answer[i] == 0` instead.
> > [!example]-
> >  **Input:** temperatures = [73,74,75,71,69,72,76,73]
> >**Output:** [1,1,4,2,1,1,0,0
>
>> [!example]-
>> **Input:** temperatures = [30,40,50,60]
>>**Output:** [1,1,1,0]
>> 


### First code
```python
class Solution:
    def dailyTemperatures(self, temperatures: list[int]) -> list[int]:
        answer = [0] * len(temperatures)
        stack = []
        for i in range(len(temperatures)):
            if i == 0:
                stack.append(i)
            else:
                if temperatures[stack[-1]] < temperatures[i]:
                     j = 1
                     while stack and temperatures[stack[-1]] < temperatures[i]:
                        prev_index = stack.pop()
                        answer[previndex] = i - previndex
                        j += 1
                stack.append(i)
        return answer
# 104ms
# Beats60.06%. 
# O(n)
```


### Solution
```python
from collections import deque

class Solution:
    def dailyTemperatures(self, temperatures):
        deq = deque()
        res = [0] * len(temperatures)

        for i in range(len(temperatures) - 1, -1, -1):
            if not deq:
                deq.appendleft(i)
                res[i] = 0
            else:
                while deq and temperatures[i] >= temperatures[deq[0]]:
                    deq.popleft()

                if not deq:
                    res[i] = 0
                else:
                    res[i] = deq[0] - i

                deq.appendleft(i)

        return res
```

