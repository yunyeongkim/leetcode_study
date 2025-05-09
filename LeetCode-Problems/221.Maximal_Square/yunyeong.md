> [!question] 
> Given an `m x n` binary `matrix` filled with `0`'s and `1`'s, _find the largest square containing only_ `1`'s _and return its area_.
> ![[leetcode_study/lib/Excaildraw/yunyeongkim/image-1.png]]
> > [!example]+
> > **Input:** matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
> > **Output:** 4

### Definition
- Square -> x == y 
- find max square 
- Using 2 loop , iterate (i, j )

### First Solution
```python
class Solution:
    def maximalSquare(self, matrix: list[list[str]]) -> int:
        result = 0  
        rows, cols = len(matrix), len(matrix[0]) 
        
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == "1":  
                    size = 1  
                    while True:
                    
                        if i + size >= rows or j + size >= cols:
                            break 

                        for k in range(size + 1):  
                            if matrix[i + k][j + size] == "0" or matrix[i + size][j + k] == "0":
                                break
                        else:
                            size += 1
                        break 

                   
                    result = max(result, size)

        return result ** 2

# Time limit exceeded.
```

### First code explain.
- It can not detect 0 inside of square. 
- O(n³) , not really good speed.


### Solution
```python
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix) < 1:
            return 0
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        dp = [[0]*(cols+1) for _ in range(rows+1)]
        max_side = 0
        
        for r in range(rows):
            for c in range(cols):
                if matrix[r][c] == '1':
                    dp[r+1][c+1] = min(dp[r][c], dp[r+1][c], dp[r][c+1]) + 1 # Be careful of the indexing since dp grid has additional row and column
                    max_side = max(max_side, dp[r+1][c+1])
                
        return max_side * max_side
```

