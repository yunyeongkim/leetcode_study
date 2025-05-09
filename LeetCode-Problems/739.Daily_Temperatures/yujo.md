# 739. Daily Temperatures

## 1. Definition

- An array of numbers is given.
- Each element in the array represents a temperature. Return an array that shows how many days you need to wait from the current index to encounter a higher temperature.
- If no higher temperature is found, return 0.

## 2. First Code(5 min) (Failed: Time Limit Exceeded)

```ts
function dailyTemperatures(temperatures: number[]): number[] {
  const result: number[] = [];

  for (let i = 0; i < temperatures.length; i++) {
    let days = 0;
    for (let j = i + 1; j < temperatures.length; j++) {
      if (temperatures[j] > temperatures[i]) {
        days = j - i;
        break;
      }
    }
    result.push(days);
  }

  return result;
}
```

## 3. First Code Explain

- Directly iterate through the array and count the days until finding a higher temperature.
- If no higher temperature is found, return 0.
- Time and Space Complexity
  - Time Complexity: O(n^2)
  - Space Complexity: O(n)

## 4. Optimized Code

```ts
function dailyTemperatures(temperatures: number[]): number[] {
  const n = temperatures.length;
  const result = new Array(n).fill(0); // Initialize result array with zeros
  const stack: number[] = []; // Stack to store indices

  for (let i = 0; i < n; i++) {
    // If current temperature is higher than the temperature at stack's top index
    while (
      stack.length > 0 &&
      temperatures[i] > temperatures[stack[stack.length - 1]]
    ) {
      const prevDay = stack.pop()!; // Previous day's index
      result[prevDay] = i - prevDay; // Calculate days difference
    }
    stack.push(i); // Add current index to stack
  }

  return result;
}
```

## 5. Optimized Code Explain

- Initialization:
  - result: Initialize array of length n with zeros (maintains 0 for temperatures with no higher future temperature)
  - stack: Empty stack to store indices
- Operation:
  - Iterate through the array once to process each temperature
  - Stack stores indices of days that haven't found a higher temperature yet
  - When current temperature is higher than the temperature at stack's top, calculate the result for that day
- Time and Space Complexity
  - Time Complexity: O(n)
  - Space Complexity: O(n)
