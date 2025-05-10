function countStudents(students: number[], sandwiches: number[]): number {
  let count = 0;

  while (true) {
    if (sandwiches[0] === students[0]) {
      sandwiches.shift();
      students.shift();
      count = 0;
    } else {
      const firstStudent = students.shift();
      students.push(firstStudent);
      count++;
    }

    if (count === students.length) break;
  }

  return count;
}