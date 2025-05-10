impl Solution {
    pub fn count_squares(matrix: Vec<Vec<i32>>) -> i32 {
        let mut ans = 0;
        let (n, m) = (matrix.len(), matrix[0].len());
        let mut DP = vec![vec![0; m]; n];

        for i in 0..m {
            if matrix[0][i] == 1 {
                DP[0][i] = 1;
                ans += 1;
            }
        }

        for i in 1..n {
            if matrix[i][0] == 1 {
                DP[i][0] = 1;
                ans += 1;
            }
        }

        for i in 1..n {
            for j in 1..m {
                if matrix[i][j] == 1 {
                    DP[i][j] = DP[i - 1][j] 
                                .min(DP[i][j - 1])
                                .min(DP[i - 1][j - 1]) + 1;
                    ans += DP[i][j];
                }
            }
        }

        ans
    }
}