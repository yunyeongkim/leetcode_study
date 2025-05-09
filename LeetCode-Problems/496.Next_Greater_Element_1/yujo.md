# 643. Maximum Average Subarray I

## 1. Definition

- Two arrays of numbers, nums1 and nums2, are given.
- For each element in nums1, find the next greater element in nums2 starting from its position.
- If no such element exists, add -1.
- The returned array must have the same length as nums1.

## 2. First Code(5 min)

```ts
function nextGreaterElement(nums1: number[], nums2: number[]): number[] {
  const result: number[] = [];

  for (const num of nums1) {
    const nums2Index = nums2.indexOf(num);
    let nextGreater = -1;

    for (let i = nums2Index; i < nums2.length; i++) {
      if (nums2[i] > num) {
        nextGreater = nums2[i];
        break;
      }
    }

    result.push(nextGreater);
  }

  return result;
}
```

## 3. First Code Explain

- For each element in nums1, find the next greater element in nums2 starting from its position.
- If no such element exists, add -1.
- Time and Space Complexity
  - Time Complexity: O(n^m)
  - Space Complexity: O(n)

## 4. Optimized Code

```ts
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
```

## 5. Optimized Code Explain

- Iterate through nums2 to find next greater elements.
- If current number is greater than the top of stack, it is the next greater element for the popped number.
- Numbers remaining in stack have no next greater element.
- The returned array must have the same length as nums1.
- Time and Space Complexity
  - Time Complexity: O(n)
  - Space Complexity: O(n)
