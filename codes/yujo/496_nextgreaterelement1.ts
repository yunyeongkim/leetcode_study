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