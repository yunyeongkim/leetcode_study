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