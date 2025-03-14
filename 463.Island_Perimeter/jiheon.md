[link](https://leetcode.com/problems/island-perimeter)


## first cod

> Iterate through every cell and check it four neighboring directions.
If a neighboring cell is empty, increment the answer by 1

```rust
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
```


## more efficent

> It is guaranteed that there is only one island.
> Iterate through each cell and check if each cell's right and left neighbors exist.https://leetcode.com/problems/island-perimeter/
> We can derive the answer using $cell\_count * 4 - neighbors*2$ (because each cell contributes 4 to Perimeter and every neighbor is counted twice)

```rust
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
```