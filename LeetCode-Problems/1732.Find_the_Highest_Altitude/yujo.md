# 1732. Find the Highest Altitude

## 1. Definition

- An array of integers is given.
- Each integer represents the altitude of a point.
- Return the highest altitude.

## 2. First Code (3 min)

```ts
function largestAltitude(gain: number[]): number {
  const altitudes: number[] = [0];

  for (let i = 0; i < gain.length; i++) {
    altitudes.push(altitudes[i] + gain[i]);
  }

  return Math.max(...altitudes);
}
```

## 3. First Code Explain

- The first element of the array starts with 0.
- Iterate through the entire gain array and add values to the altitudes array.
- Return the maximum value from the final altitudes array.

## 4. Optimized Code

```ts
function largestAltitude(gain: number[]): number {
  let max = 0;
  let current = 0;

  for (let i = 0; i < gain.length; i++) {
    current += gain[i];

    if (current > max) {
      max = current;
    }
  }

  return max;
}
```

## 5. Optimized Code Explain

- The first element starts with 0.
- Iterate through the entire gain array and add the current position's value to the previous position's value.
- Replace the current position's value with the summed value.
- Lower space complexity than the previous method. O(n) -> O(1)
