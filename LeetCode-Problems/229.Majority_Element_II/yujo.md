# 229. Majority Element II

## 1. Definition

- Given an array of numbers.
- If any element appears more than n / 3 times, include that element in the result array and return it.

## 2. First Code (10 min)

```ts
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
```

## 3. First Code Explanation

- Time complexity: O(n) because we iterate through the array twice
- Space complexity: O(n) because we use a map to store the counts
- Iterate through the array and count the occurrences of each number.
- Only add numbers whose count exceeds the threshold to the result array. (threshold = n / 3)

## 4. Optimized Code

```ts
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
```

## 5. Optimized Code Explanation

- Time complexity: O(n) because we iterate through the array twice
- Space complexity: O(1) because we are not using any extra space
- Iterate through the array to select candidates.
- first, second: two candidate numbers
- count1, count2: track how many times each candidate appears
- If the current number matches a candidate, increment its count.
- If there is no candidate, register the current number as a new candidate.
- If the current number is not a candidate and there are no available slots, decrement both candidates' counts.
- Finally, check if the candidates actually satisfy the condition.
