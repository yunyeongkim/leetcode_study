> [!question]+
> You have a `RecentCounter` class which counts the number of recent requests within a certain time frame.
> Implement the `RecentCounter` class:
> - `RecentCounter()` Initializes the counter with zero recent requests.
> - `int ping(int t)` Adds a new request at time `t`, where `t` represents some time in milliseconds, and returns the number of requests that has happened in the past `3000` milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range `[t - 3000, t]`.
> 
> It is **guaranteed** that every call to `ping` uses a strictly larger value of `t` than the previous call.

## Define Problems
![[image-5.png]]
![[933_NumberOfCells_Define.excalidraw]]

### First Solution.
```python
class RecentCounter:
    def __init__(self):
        self.ping_list = [0]

    def ping(self, t: int) -> int:
        self.ping_list.append(t)
        count =0
        for i in range(len(self.ping_list) -1, 0,-1):
            if self.ping_list[i] >= max(0,t-3000):
                count += 1
            else:
		        return count
# Wrong.
```

### Second Solution
```python
class RecentCounter:
    def __init__(self):
        self.ping_list = []

    def ping(self, t: int) -> int:
        self.ping_list.append(t)
        count =0
        for i in range(len(self.ping_list) -1, -1,-1):
            if self.ping_list[i] >= max(0,t-3000):
                count += 1
            else:
                break
        return count
```

### Leet Code Solution
```python
class RecentCounter:
    def __init__(self):
        self.records = []
        self.start = 0

    def ping(self, t: int) -> int:
        self.records.append(t)
        while self.records[self.start] < t - 3000:
            self.start += 1
        return len(self.records) - self.start
```

```python
from collections import deque

class RecentCounter:
    def __init__(self):
        self.q = deque()

    def ping(self, t: int) -> int:
        self.q.append(t)
        while self.q[0] < t - 3000:
            self.q.popleft()
        return len(self.q)

```

### Explain
![[image-8.png]]
![[933.Number_of_recent_calls.excalidraw]]