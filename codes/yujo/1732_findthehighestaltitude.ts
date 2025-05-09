function largestAltitude(gain: number[]): number {
  const altitudes: number[] = [0];

  for (let i = 0; i < gain.length; i++) {
    altitudes.push(altitudes[i] + gain[i]);
  }

  return Math.max(...altitudes);
}