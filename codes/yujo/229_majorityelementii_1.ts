function majorityElement(nums: number[]): number[] {
  let first: number | null = null;
  let second: number | null = null;
  let count1 = 0;
  let count2 = 0;

  for (const num of nums) {
    if (num === first) {
      count1++;
    } else if (num === second) {
      count2++;
    } else if (count1 === 0) {
      first = num;
      count1 = 1;
    } else if (count2 === 0) {
      second = num;
      count2 = 1;
    } else {
      count1--;
      count2--;
    }
  }

  count1 = 0;
  count2 = 0;
  for (const num of nums) {
    if (num === first) count1++;
    else if (num === second) count2++;
  }

  const result: number[] = [];
  const threshold = Math.floor(nums.length / 3);
  if (count1 > threshold) result.push(first!);
  if (count2 > threshold) result.push(second!);

  return result;
}