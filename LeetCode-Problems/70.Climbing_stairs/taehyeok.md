## IDEA

Because we can only move 1 or 2 steps at a time
to reach step n, we must come from step (n-1) or (n-2)
This creates a recursive structure like:
             n
          /     \
       n-1       n-2
      /   \      /   \
   n-2   n-3  n-3   n-4
In this visualization, if we use only recursion we visit n-3 step twice.
Besides n-3 step, in this approach, there are lots of steps that are visited many times

When the level is low, there are only a few nodes that are visited more than once.
But as the level gets deeper, many nodes are visited repeatedly

So, TC of this approach is O(2^n)
To reduce this time complexity, I will use DP to store previous results
If we use DP, TC can be O(n)

We will use the recursion relation dp[n] = dp[n-1] + dp[n-2], because to reach step n, you can only come from step n-1 or n-2
To do this, we first need to intialize the base cases:
We set dp[1] = 1, because there's only one way to reach first step
and dp[2] = 2, because there are two ways to reach second step (1 + 1 or 2)
However, to make the formula more general, we can set dp[0] = 1

## Trial

```python
class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [0] * (n + 1)
        for i in range(n + 1):
            if i == 0 or i == 1:
                dp[i] = 1
                continue
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n]


```



## Time Complexity 
`O(n)`: Because we visit each step only once


## Space Complexity
`O(n)`: Because we use dp list to store previous results
So we need only n space




