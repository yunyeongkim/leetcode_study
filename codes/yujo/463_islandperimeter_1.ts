function islandPerimeter(grid: number[][]): number {
  const rows = grid.length;
  const cols = grid[0].length;
  let count = 0;
  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      if (grid[i][j] === 1) {
        count += 4;
        if (i > 0 && grid[i - 1][j] === 1) {
          count -= 2;
        }

        if (j > 0 && grid[i][j - 1] === 1) {
          count -= 2;
        }
      }
    }
  }

  return count;
}