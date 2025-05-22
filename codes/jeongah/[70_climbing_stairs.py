class Solution(object):
    def climbStairs(self, n):
        steps = [1 for i in range(n + 1)]
        
        for num in range(n + 1):
            if num == 0 or num == 1:
                steps[num] = 1
                continue

            steps[num] = steps[num - 1] + steps[num - 2]
        
        return steps[n]