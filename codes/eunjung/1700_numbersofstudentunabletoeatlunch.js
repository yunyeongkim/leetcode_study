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