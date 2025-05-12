function countStudents(students: number[], sandwiches: number[]): number {
  const preference = [0, 0];

  for (const student of students) {
    preference[student]++;
  }

  for (const sandwich of sandwiches) {
    if (preference[sandwich] === 0) {
      break;
    }
    preference[sandwich]--;
  }

  return preference[0] + preference[1];
}