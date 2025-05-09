function findMaxAverage(nums: number[], k: number): number {
  let max = -Infinity;
  let sum = 0;

  for (let i = 0; i < nums.length; i++) {
    sum += nums[i];

    if (i >= k) {
      sum -= nums[i - k];
    }

    if (i >= k - 1) {
      max = Math.max(max, sum);
    }
  }

  return max / k;
}