DEBUG = False

def vimkim(*a, **ka):
if DEBUG:
print(*a, **ka)

class Solution:
def maximalSquare(self, matrix: List[List[str]]) -> int:

        N = len(matrix)
        M = len(matrix[0])

        ### Stage 1: Precompute the sequences length

        # how many 1s above
        matUp = [[0 for _ in range(M+1)] for _ in range(N+1)]
        # how many 1s in the left direction
        matLeft = [[0 for _ in range(M+1)] for _ in range(N+1)]

        for i in range(1, N+1):
            for j in range(1, M+1):

                if matrix[i-1][j-1] == "1":
                    matUp[i][j] = matUp[i-1][j] + 1
                    matLeft[i][j] = matLeft[i][j-1] + 1

        vimkim("matUp")
        vimkim(*matUp, sep='\n')
        vimkim("matLeft")
        vimkim(*matLeft, sep='\n')

        ### Stage 2: calculate the area on the i-1, j-1 position
        ### so that we can expand

        memo = [[0 for _ in range(M+1)] for _ in range(N+1)]

        max_ = 0

        for i in range(1, N+1):
            for j in range(1, M+1):
                if matrix[i-1][j-1] == "1":
                    memo[i][j] = min(
                        matLeft[i][j],
                        matUp[i][j],
                        memo[i-1][j-1] + 1
                    )
                    max_ = max(max_, memo[i][j])


        vimkim("memo")
        vimkim(*memo, sep='\n')
        return max_ * max_