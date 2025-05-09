[problem](https://leetcode.com/problems/number-of-students-unable-to-eat-lunch//)

This can be solved without `deque` structure


## Solution
-  Since all elements in array are either `0` or  `1` , So I use  the array`prefer(int[2])` to count how  many students prefer each type of sandwich
- Using `0` as an example,  while iterating through the `sandwiches`  if  the current sandwich is `0` but no student prefers it, then no one can take the sandwich. At that point, I return the number of remaining students who prefer the other type as the answer.


```java
class Solution {
       public int countStudents(int[] students, int[] sandwiches) {
        int[] prefer = new int[2];

        for (int student : students) {
            prefer[student]++;
        }

        for (int sandwich : sandwiches) {
            if (prefer[sandwich] <= 0) return prefer[1 - sandwich];
            prefer[sandwich]--;
        }
        return 0;
    }
}
```

