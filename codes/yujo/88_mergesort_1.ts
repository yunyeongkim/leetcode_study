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