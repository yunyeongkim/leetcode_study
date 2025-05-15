> [!question]+
> You are climbing a staircase. It takes `n` steps to reach the top.
> Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top?
>- `1 <= n <= 45`



### Definition
- Only 1-2 steps allowed. 
- I think there are some logic that we can use here mathematically. 
- 

```python
class Solution:
    def climbStairs(self, n: int) -> int:
        max = 0
        count = 0
        left_steps=n
        while max <= n-1 :
            left_steps -= max
            print(f"max = {max} / left_step = {left_steps}")
            if left_steps == 0:
                count += 1
                left_steps = n
                max +=1
            if left_steps >= 2:
                left_steps -= 2
            else:
                left_steps -= 1
        return count

```