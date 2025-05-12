function nextGreaterElement(nums1: number[], nums2: number[]): number[] {
  // Use Map to store the next greater element for each number
  const nextGreater = new Map<number, number>();
  // Monotonic decreasing stack
  const stack: number[] = [];

  // Iterate through nums2 to find next greater elements
  for (const num of nums2) {
    // If current number is greater than the top of stack,
    // it is the next greater element for the popped number
    while (stack.length > 0 && stack[stack.length - 1] < num) {
      nextGreater.set(stack.pop()!, num);
    }
    stack.push(num);
  }

  // Numbers remaining in stack have no next greater element
  while (stack.length > 0) {
    nextGreater.set(stack.pop()!, -1);
  }

  // Add next greater element for each number in nums1 to result array
  return nums1.map((num) => nextGreater.get(num)!);
}