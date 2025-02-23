# 561. Array Partition

## 1. Definition

- pair two values and only use min value between two values

  - ex) min(1, 2) => 1 , min(3, 4) => 3
  - sum of min value pair is result and return max sum

- nums is array of integer
- length of nums is even
- 1 <= nums[i] <= 10^4

## 2. First Code. (10min)

```ts
function arrayPairSum(nums: number[]): number {
  return nums
    .sort((a, b) => a - b)
    .filter((_, index) => index % 2 === 0)
    .reduce((acc, cur) => (acc += cur));
}
```

## 3. First Code Explain

- I thought this couldn't be solved using brute force. If we compare all numbers one by one, we would need to iterate through all numbers in the 10^4 range (10^4 - 1) times and store those values. This would use a lot of memory and result in a time complexity of `O(n^2)`.
- Therefore, I analyzed the pattern of the problem. To use the largest possible values, we need to find numbers that are either equal or differ by -1.
- I realized that if we sort the entire array, the number at index -1 relative to the current position would be the largest possible value when performing `Math.min()`.
- Thus, I found the optimal solution by sorting the array in ascending order and using `filter()` logic to sum all values at even indices.

| Method   | Time Complexity |
| -------- | --------------- |
| sort()   | O(n log n)      |
| filter() | O(n)            |
| reduce() | O(n)            |

## 4. Optimized Code

```ts
function arrayPairSum(nums: number[]): number {
  nums.sort((a, b) => a - b);
  let sum = 0;
  for (let i = 0; i < nums.length; i += 2) {
    sum += nums[i];
  }
  return sum;
}
```

## 5. Optimized Code Explain

- Reduced the number of array iterations by one.
- However, this optimization doesn't show significant difference in the LeetCode judging program.
