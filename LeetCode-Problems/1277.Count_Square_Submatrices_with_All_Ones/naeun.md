Q: https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/

## my solution
- Runtime: 7ms,44.24%
- Memory: 56.68MB, 10.77%

```java
class Solution {
    int result = 0;
    public int countSquares(int[][] matrix) {
        // 1로 드는 정사각형
        // 정사각형이 될때마다 숫자를 올려준다!
        // 2중 for문을 돌면서 확인하고 recursive하게 체크
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    result +=1;
                    checkSqr(i, j, 2, matrix);
                }
            }
        }
        return result;
    }

    private void checkSqr(int i, int j, int size, int[][] matrix){
        // 벗어나는 부분 처리
        if(i+size-1 >= matrix.length || j+size-1 >= matrix[0].length){
            return;
        }

        // row
        for(int c = 0; c < size; c++){
            if(matrix[i+size-1][j+c] == 0){
                return;
            }
        }

        // col
        for(int r = 0; r < size; r++){
            if(matrix[i+r][j+size-1] == 0){
                return;
            }
        }
        
        result+=1;
        checkSqr(i, j, size+1, matrix);
    }
}
```
- time complexity: O(n^2)
- space complexity: O(n) but stack memory,,,?!

## other solutions
- Runtime: 7ms, 44.24%
- Memory: 54.73MB, 92.55%

- dp means previous squares count
- use extended dp matrix with additional space.
```java
class Solution {
    public int countSquares(int[][] matrix) {
    // 확장된 dp 사용(out of index 처리)
    int dp[][] = new int[matrix.length+1][matrix[0].length+1];
    int ans = 0; 
    for(int i=0; i<matrix.length; i++){
      for(int j=0; j<matrix[0].length; j++){
        // matrix i,j는 dp의 i+1, j+1과 같음.
        if(matrix[i][j]==1){
            dp[i+1][j+1] = 1 + Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1]));
        }
        ans += dp[i+1][j+1];
      }  
    }  
    return ans;
    }
}
```
```text
matrix
1 1 1 1
1 1 1 0
1 1 1 0
0 0 0 0

dp
0 0 0 0 0
0 1 1 1 1
0 1 2 2 0
0 1 2 3 0 
0 0 0 0 0
```