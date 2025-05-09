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