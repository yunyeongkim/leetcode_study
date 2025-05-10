# 169. Majority Element

## 1. Definition

- Array `nums` , Array.length = `n`
  - 1 <= n <= 5 \* 10^4
  - -10^9 <= nums[i] <= 10^9
- return to more than n / 2 element
- **Follow-up:** Could you solve the problem in linear time and in O(1) space?

## 2. First Code. (5min)

```ts
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
```

## 3. First Code Explain

- Record the number of appearances for each key while traversing the entire array
- Find and return the most frequent value (or element with the maximum count)
  | | Big O |
  |----------------------|-------|
  | **Time Complexity** | O(n) |
  | **Space Complexity** | O(n) |

## 4. Optimized Code

```ts
function majorityElement(nums: number[]): number {
  let candidate;
  let count = 0;

  for (const num of nums) {
    if (count === 0) {
      candidate = num;
    }

    count += num === candidate ? 1 : -1;
  }

  return candidate;
}
```

## 5. Optimized Code Explain

- The majority element appears more than n/2 times in the array.
- Therefore, if we iterate through the array and keep track of a candidate element and its count, incrementing when we see the candidate and decrementing otherwise, the final remaining number will be the majority element.
- This approach is known as the Boyer-Moore Voting Algorithm.
  - https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
- The time complexity remains O(n), but the space complexity is reduced to O(1).
  | | Big O |
  |----------------------|-------|
  | **Time Complexity** | O(n) |
  | **Space Complexity** | O(1) |
