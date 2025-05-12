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