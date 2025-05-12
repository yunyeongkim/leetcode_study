impl Solution {
    pub fn island_perimeter(grid: Vec<Vec<i32>>) -> i32 {
        let (n, m) = (grid.len(), grid[0].len());
        let (mut land_cnt, mut neighbors) = (0,0);
        for i in 0..n {
            for j in 0..m {
                if grid[i][j] == 1 {
                    land_cnt += 1;
                    if i != n - 1 && grid[i + 1][j] == 1 {
                        neighbors += 1
                    }

                    if j != m - 1 && grid[i][j + 1] == 1 {
                        neighbors += 1
                    }
                }
            }
        }

        land_cnt * 4 - neighbors * 2
    }
}