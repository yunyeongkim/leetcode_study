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