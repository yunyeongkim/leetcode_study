# 463. Island Perimeter

## 1. Definition

When a grid is given, 1 represents land and 0 represents water.
Calculate and return the perimeter where land meets water.

## 2. First Code (20 min)

```ts
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
```

## 3. First Code Explanation

Traverse the entire grid and when we encounter a 1, check if adjacent sides are land (1) and subtract from the count accordingly.

## 4. Optimized Code

```ts
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
```

## 5. Optimized Code Explanation

When two cells are adjacent, the boundary between them is shared. Therefore, we subtract 2 at once to calculate the shared boundary of both cells, reducing the number of calculations by half.
