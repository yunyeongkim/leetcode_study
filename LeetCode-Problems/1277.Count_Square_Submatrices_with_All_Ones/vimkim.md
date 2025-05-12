I liked the trick in the original solution.

Instead of explicitly counting squares of different sizes, like:

- `10` squares of size `1x1`
- `4` squares of size `2x2`
- `1` square of size `3x3`

The total is `15` squares.

Instead, we can directly accumulate the values as follows:

```text
6 * 1 + 3 * 2 + 1 * 3 = 15
```

So, the solution effectively reduces to the sum of all contributions.

### Original Solution

```python
class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:

        N = len(matrix)
        M = len(matrix[0])
        memo = [[0 for _ in range(M+1)] for _ in range(N+1)]

        sum_ = 0
        for i in range(N):
            for j in range(M):
                if matrix[i][j] == 1:
                    value = min(
                        memo[i+1][j],
                        memo[i][j+1],
                        memo[i][j]
                    ) + 1
                    memo[i+1][j+1] = value
                    sum_ += value
        return sum_
```

### Optimized Version

This version is even faster, since the `sum` function is implemented in C.

The performance gain is minor due to Python's relatively slow runtime compared to C, but it still makes the code cleaner and potentially faster.

```python
class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:

        N = len(matrix)
        M = len(matrix[0])
        memo = [[0 for _ in range(M+1)] for _ in range(N+1)]

        for i in range(N):
            for j in range(M):
                if matrix[i][j] == 1:
                    value = min(
                        memo[i+1][j],
                        memo[i][j+1],
                        memo[i][j]
                    ) + 1
                    memo[i+1][j+1] = value

        sum_ = 0
        for i in range(N):
            sum_ += sum(memo[i])

        return sum_
```

### Why This is Faster

- The `sum` function in Python is implemented in C, which is faster than manually accumulating values in a Python loop.
- Moving the summation to the end reduces the overhead of frequent additions during the main loop.

The difference is trivial due to Python's runtime speed, but it still makes the code cleaner and more efficient.
