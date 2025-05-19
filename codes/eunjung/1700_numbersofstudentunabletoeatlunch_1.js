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