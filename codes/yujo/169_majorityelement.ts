function majorityElement(nums: number[]): number {
  const map: Record<string, number> = {};

  for (const num of nums) {
    if (map[num]) {
      map[num] = map[num] += 1;
    } else {
      map[num] = 1;
    }
  }

  const maxValue = Math.max(...Object.values(map));
  const maxKey = Object.keys(map).find((key) => map[key] === maxValue);

  return Number(maxKey);
}