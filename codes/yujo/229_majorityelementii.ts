function majorityElement(nums: number[]): number[] {
  const countMap = new Map<number, number>();
  const result: number[] = [];
  const threshold = Math.floor(nums.length / 3);

  for (const num of nums) {
    countMap.set(num, (countMap.get(num) || 0) + 1);
  }

  for (const [num, count] of countMap.entries()) {
    if (count > threshold) {
      result.push(num);
    }
  }

  return result;
}