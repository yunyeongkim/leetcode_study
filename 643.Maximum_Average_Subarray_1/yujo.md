# 643. Maximum Average Subarray I

## 1. Definition

- Given nums and k, we need to find and return the maximum average value of a contiguous subarray of length k in nums.
- The result should be returned with 5 decimal places.

## 2. First Code(5 min)

```ts
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
```

## 3. First Code Explain

- The first code uses a brute force approach that explores all possible subarrays.
- This method has a time complexity of O(n^2), which causes a time limit exceeded error.

## 4. Optimized Code

```ts
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
```

## 5. Optimized Code Explain

- The second code uses a sliding window technique to reduce the time complexity to O(n).
- Unlike the first code, this method doesn't explore all possibilities but traverses the array only once.
