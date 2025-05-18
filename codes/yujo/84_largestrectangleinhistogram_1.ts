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