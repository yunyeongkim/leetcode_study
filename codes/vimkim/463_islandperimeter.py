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