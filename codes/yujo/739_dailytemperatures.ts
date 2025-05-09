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