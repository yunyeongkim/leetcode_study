This was not too difficult.

To solve it, I can traverse the entire 2D array with a time complexity of O(n \* n). For each cell, I will check its neighbors to the right and below. If a neighboring cell has a different value, I will add one to the perimeter count.

Here’s an example in Python:

```python
class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        N = len(grid)
        M = len(grid[0])

        count = 0
        directions = ((1, 0), (0, 1))

        for i in range(N):
            for j in range(M):
                if grid[i][j] == 1:
                    count += 4  # Add 4 sides for each land cell

                    for di, dj in directions:
                        ni, nj = i + di, j + dj

                        if 0 <= ni < N and 0 <= nj < M and grid[ni][nj] == 1:
                            count -= 2  # Subtract 2 sides for each adjacent land cell
        return count
```

**Optimized Approach Explanation:**

If I encounter a land cell (with a value of 1), I immediately add 4 to the perimeter.

The logic is straightforward: if two land cells are adjacent, each one loses one side of its perimeter. Therefore, I need to subtract 2 for each pair of adjacent land cells.

To avoid redundant subtraction, I traverse the grid only once and check only the right and bottom neighbors for each cell. This ensures that each pair of adjacent land cells is only considered once.

This approach is efficient and keeps the time complexity at O(n \* m).
