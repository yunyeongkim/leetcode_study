# 88. Merge Sorted Array

## 1. Definition

- Problem: Merge nums2 into nums1 to create a new array.
- nums1 has length m, nums2 has length n
- The final array should:

  - Have length m + n
  - Be sorted in ascending order

- Edge cases:
  - If nums1 length (`m`) is 0 -> Overwrite nums1 with nums2
  - If nums2 length (`n`) is 0 -> End function as is

## 2. First Code. (10min)

```ts
function merge(nums1: number[], m: number, nums2: number[], n: number): void {
  if (m === 0) {
    nums1.splice(0, n, ...nums2);
    return;
  }

  if (n === 0) {
    return;
  }

  nums1.splice(m, m + n, ...nums2);
  nums1.sort((a, b) => a - b);
}
```

## 3. First Code Explain

- First, handle edge cases where m is 0 and n is 0
- Then overwrite the empty space in nums1 with nums2 and sort
- Time complexity is O(n log n), Space complexity is O(n)

| Method | Time Complexity |
| ------ | --------------- |
| splice | O(n)            |
| sort   | O(n log n)      |

## 4. Optimized Code

```ts
function merge(nums1: number[], m: number, nums2: number[], n: number): void {
  // Initialize pointers for both arrays and the merge position
  let nums2Pointer = n - 1; // Points to the last element of nums2
  let nums1Pointer = m - 1; // Points to the last element of nums1
  let mergePointer = m + n - 1; // Points to the last position of merged array

  // Continue until we process all elements from nums2
  while (nums2Pointer >= 0) {
    const shouldUseNums1 =
      nums1Pointer >= 0 && nums1[nums1Pointer] > nums2[nums2Pointer];

    if (shouldUseNums1) {
      nums1[mergePointer] = nums1[nums1Pointer];
      nums1Pointer--;
    } else {
      nums1[mergePointer] = nums2[nums2Pointer];
      nums2Pointer--;
    }
    mergePointer--;
  }
}
```

## 5. Optimized Code Explain

- Using two-pointer approach to improve space complexity to O(1)
- Start from the end of both nums1 and nums2, filling nums1 from the end with larger numbers
- Time complexity is O(n + m), Space complexity is O(1)

| Improvement      | Before     | After    |
| ---------------- | ---------- | -------- |
| Time Complexity  | O(n log n) | O(n + m) |
| Space Complexity | O(n)       | O(1)     |
