class Solution:
    def countSquares(self, matrix: list[list[int]]) -> int:
        dp = matrix
        for i in range(len(matrix)):
                for j in range(len(matrix[i])):
                    if matrix[i][j] > 0 and i > 0 and j > 0:
                         # Fisrt line should be set as default.
                         dp[i][j] =  min(dp[i-1][j] , dp[i][j-1],dp[i-1][j-1]) + 1
        return sum(sum(row) for row in dp)
        
#Time Complexity: O(m × n), iterates over each cell once.
#Space Complexity: O(1) (In-place DP, no extra space).