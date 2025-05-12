# 84. Largest Rectangle in Histogram

## 1. Definition

- Given an array of integers representing the height of bars in a histogram.
- Find the largest rectangle that can be formed in the histogram.

## 2. First Code (15 min)

```ts
function largestRectangleArea(heights: number[]): number {
  let maxArea = 0;
  const n = heights.length;

  for (let i = 0; i < n; i++) {
    let minHeight = heights[i];

    for (let j = i; j < n; j++) {
      minHeight = Math.min(minHeight, heights[j]);
      const width = j - i + 1;
      const area = minHeight * width;
      maxArea = Math.max(maxArea, area);
    }
  }

  return maxArea;
}
```

## 3. First Code Explanation

- fail: Time Limit Exceeded
- time complexity: O(n^2) because in the worst case, if all heights are 1, every combination must be checked.
- space complexity: O(1) because we are not using any extra space.

## 4. Optimized Code

```ts
function largestRectangleArea(heights: number[]): number {
  const stack: number[] = []; // Stack to store indices of heights
  let maxArea = 0;

  const extendedHeights = [...heights, 0]; // Add 0 at the end for easier cleanup

  for (let i = 0; i < extendedHeights.length; i++) {
    const currentHeight = extendedHeights[i];

    while (
      stack.length > 0 &&
      currentHeight < extendedHeights[stack[stack.length - 1]]
    ) {
      const topIndex = stack.pop()!;
      const heightAtTop = extendedHeights[topIndex];

      const isStackEmpty = stack.length === 0;
      const leftBoundaryIndex = isStackEmpty ? -1 : stack[stack.length - 1];
      const width = i - leftBoundaryIndex - 1;

      const area = heightAtTop * width;
      maxArea = Math.max(maxArea, area);
    }

    stack.push(i);
  }

  return maxArea;
}
```

## 5. Optimized Code Explanation

- time complexity: O(n) because each bar is pushed and popped only once
- space complexity: O(n) because the stack can store up to n indices
- Indices of increasing heights are stored in the stack
- When the current bar is shorter, pop from the stack and calculate the area
- Each bar is pushed and popped exactly once
