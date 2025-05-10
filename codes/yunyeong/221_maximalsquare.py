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