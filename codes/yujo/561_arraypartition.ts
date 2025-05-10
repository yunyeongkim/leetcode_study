function arrayPairSum(nums: number[]): number {
  return nums
    .sort((a, b) => a - b)
    .filter((_, index) => index % 2 === 0)
    .reduce((acc, cur) => (acc += cur));
}