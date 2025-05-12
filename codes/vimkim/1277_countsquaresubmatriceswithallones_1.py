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