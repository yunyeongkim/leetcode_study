impl Solution {
    pub fn count_squares(matrix: Vec<Vec<i32>>) -> i32 {
        let (n, m) = (matrix.len(), matrix[0].len());
        let mut ans = 0;
        let mut DP = vec![0; m];
        let mut prev = 0;

        for i in 0..n {
            for j in 0..m {
                let tmp = DP[j];

                if matrix[i][j] == 1 {
                    if i == 0 || j == 0 {
                        DP[j] = 1;
                    } else {
                        DP[j] = DP[j].min(DP[j - 1]).min(prev) + 1;
                    }
                    ans += DP[j];
                } else {
                    DP[j] = 0;
                }
                prev = tmp;
            }
        }

        ans
    }
}