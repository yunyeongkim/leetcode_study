# 1480. Running Sum of 1d Array

## 1. Definition

- Given an array of numbers.
- Each index in the array represents the sum of all numbers up to that index.
- ex) [1, 2, 3, 4] -> [1, 3, 6, 10]

## 2. First Code (3 min)

```ts
function runningSum(nums: number[]): number[] {
  let sum = 0;

  const result = [];

  for (let i = 0; i < nums.length; i++) {
    sum = sum + nums[i];

    result.push(sum);
  }

  return result;
}
```

## 3. First Code Explain

- Declare a sum variable that holds all values up to the current array position.
- Iterate through the array and add the current value to sum.
- Add the summed value to the result array.

## 4. Optimized Code

```ts
function runningSum(nums: number[]): number[] {
  for (let i = 1; i < nums.length; i++) {
    nums[i] += nums[i - 1];
  }
  return nums;
}
```

## 5. Optimized Code Explain

- Iterate through the array and add the previous position's value to the current position.
- Replace the current position's value with the summed value.
- Lower space complexity than the previous method. O(n) -> O(1)
