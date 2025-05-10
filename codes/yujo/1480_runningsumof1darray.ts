function runningSum(nums: number[]): number[] {
  let sum = 0;

  const result = [];

  for (let i = 0; i < nums.length; i++) {
    sum = sum + nums[i];

    result.push(sum);
  }

  return result;
}