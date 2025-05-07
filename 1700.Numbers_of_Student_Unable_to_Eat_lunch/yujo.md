# 1700. Number of Students Unable to Eat Lunch

## 1. Definition

- given two arrays:
  - students: an array of 0s and 1s representing student sandwich preferences (0 =circular, 1 = square).
  - sandwiches: an array of 0s and 1s representing the top-down order of sandwiches in astack.
- students are in a queue.
- if the student at the front likes the top sandwich, they take it and both are removed.
- if not, the student moves to the end of the queue.
- this continues until no one wants the sandwich at the top.
- return the number of students unable to eat.

## 2. First Code (5 min)

```ts
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
```

## 3. First Code Explain

- time complexity: O(n^2) because we are using shift and push which are O(n) operations.
- space complexity: O(1) because we are not using any extra space.
- we keep rotating students until a student eats or all remaining students refuse the current sandwich.
- if count reaches the number of students, that means everyone passed once without taking the sandwich, so we can stop.

## 4. Optimized Code

```ts
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
```

## 5. Optimized Code Explain

- time complexity: O(n + m) because we are iterating through the students and sandwiches once.
- space complexity: O(1) because we are not using any extra space.
- we count the number of students who prefer each sandwich type.
- if no one wants the current sandwich, we break.
- otherwise, we decrement the count of that sandwich type.
- in the end, we return the sum of the remaining students.
