// Time Limit Exceeded
function findMaxAverage(nums: number[], k: number): number {
  let max = -Infinity;

  for (let i = 0; i < nums.length - k + 1; i++) {
    let sum = 0;
    for (let j = 0; j < k; j++) {
      sum += nums[i + j];
    }

    max = Math.max(max, sum);
  }

  return max / k;
}