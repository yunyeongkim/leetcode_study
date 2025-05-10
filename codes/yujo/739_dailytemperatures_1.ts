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