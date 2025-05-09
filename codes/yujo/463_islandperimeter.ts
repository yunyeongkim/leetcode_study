function islandPerimeter(grid: number[][]): number {
  let count = 0;
  const gridLength = grid.length;
  const gridItemLength = grid[0].length;
  for (let i = 0; i < gridLength; i++) {
    for (let j = 0; j < gridItemLength; j++) {
      if (grid[i][j] === 1) {
        count += 4;
        if (i > 0 && grid[i - 1][j] === 1) count -= 1;
        if (j > 0 && grid[i][j - 1] === 1) count -= 1;
        if (i < gridLength - 1 && grid[i + 1][j] === 1) count -= 1;
        if (j < gridItemLength - 1 && grid[i][j + 1] === 1) count -= 1;
      }
    }
  }
  return count;
}