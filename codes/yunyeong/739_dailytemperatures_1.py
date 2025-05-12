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