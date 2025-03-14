
[question](https://leetcode.com/problems/count-square-submatrices-with-all-ones)

## idea
- Iterate through each cell to calculate the number of possible squares for which  the cell is bottom-right corner.
- When calculating the cell [i][j], the previous results of the cells [i-1][j],[i][j-1],[i-1][j-1] will affect it. (for i>0,j>0)


## first code ( 2-dimensional DP)
```rust
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
```

## More efficient (1-dimensional DP)
-  As I mentioned in idea section, we only use [i-1][j],[i][j-1] and [i-1][j-1] to calculate the 
possible number of squares where cell[i][j] is the bottom-right corner.

- If we use 1-dimensional DP, the current cell is [i-1][j] and the left cell is DP[i][j-1].
we can't maintain DP[i-1][j-1] in the DP array because the left cell was already updated to DP[i-1][j] in the prev iteration. , so we store it in a temporary variable from the previous iteration.

```
prev => [i-1][j-1]

[ ][X]  //x min 
 |  |
 |  dp[i-1][j]  // x is current iteration
 |
 dp[i][j-1]
```


```rust
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
```
