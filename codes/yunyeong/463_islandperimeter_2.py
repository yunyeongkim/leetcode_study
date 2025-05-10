class Solution:
    def islandPerimeter(self, grid):
        rows, cols = len(grid), len(grid[0])
        visited = set()

        def dfs(i, j):
            if (i < 0 or i >= rows or j < 0 or j >= cols or grid[i][j] == 0):
                return 1  # 물에 닿았으면 perimeter +1
            if (i, j) in visited:
                return 0  # 이미 방문한 경우

            visited.add((i, j))
            perimeter = 0
            perimeter += dfs(i+1, j)  # 아래
            perimeter += dfs(i-1, j)  # 위
            perimeter += dfs(i, j+1)  # 오른쪽
            perimeter += dfs(i, j-1)  # 왼쪽
            return perimeter

        # 섬이 하나뿐이므로 DFS를 시작할 위치를 찾음
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 1:
                    return dfs(i, j)  # 섬 찾으면 DFS 실행

        return 0  # 만약 섬이 없다면 0 반환