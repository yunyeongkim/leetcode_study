
 [1700] [Number of Students Unable to Eat Lunch](https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/)

### _Explanation of the Question_

1. circular sandwiches: **0** , square sandwiches: **1**, as a **stack**
2. students stand in a **queue**
3. If the student at the front of the queue prefers the sandwich on the top of the stack, 
	- they will take it and leave the queue
	- otherwise, they move to end of the queue.
4. Return the number of students that are unable to eat
5. For example, 
	**Input:** students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
	**Output:** 3
	- Steps
		- students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
		- students = [1,1,0,0,1], sandwiches = [0,0,0,1,1]
		- students = [1,0,0,1,1], sandwiches = [0,0,0,1,1]
		- students = [0,0,1,1,1], sandwiches = [0,0,0,1,1]
		- students = [0,1,1,1], sandwiches = [0,0,1,1]
		- students = [1,1,1], sandwiches = [0,1,1]

### _First Code_
 
 - While `students.length > 0`
	 - If the student at the front of the queue prefers the sandwich on the top of the stack, 
		- they will take it and leave the queue
		- otherwise, they move to end of the queue.
- return the number of students

```javascript
/**
 * @param {number[]} students
 * @param {number[]} sandwiches
 * @return {number}
 */
var countStudents = function(students, sandwiches) {

    if(sandwiches.length < 1) return students.length;

    //case: students=[1,1,1] sandwiches=[0,0,0]
    //after we check all the values of students[i], stop checking
    //let sizeOfArray = 0;
    let count = 0;

    while(students.length > 0){
        if(students[0] === sandwiches[0]){
            students.shift();
            sandwiches.shift();
            count = 0;
        }else{
            if(count === students.length){
                break;
            }else{
                students.push(students.shift());
                count++;
            }
        }
    }

    return students.length;
};
```
- Time complexity: O(n^2)
- Space complexity: O(1)
### _Second Code_

1. Go through the students array and count how many want sandwich 0 and how many want sandwich 1. Store these in `count0` and `count1`
 2. For each sandwich in the sandwiches array:
	1. If index value of sandwiches is `0` and  there are students who want it
		- decrease `count0`
	2. If index value of sandwiches is `1` and   there are students who want it
		- decrease `count1`
	3. Otherwise, break the loop

```javascript
/**
 * @param {number[]} students
 * @param {number[]} sandwiches
 * @return {number}
 * 
 * - Time complexity: O(n)
    - Space complexity: O(1)
 */

function countStudents(students, sandwiches) {
    let count0 = 0;
    let count1 = 0;

    for(let student of students){
        if(student === 0) count0++;
        else count1++;
    }

    for(let sandwich of sandwiches){
        if(sandwich === 0 && count0 >0){
            count0--;
        }else if(sandwich === 1 && count1 > 0){
            count1--;
        }else break;
    }

    return count0 + count1;
};
```

- Time complexity: O(n)
- Space complexity: O(1)