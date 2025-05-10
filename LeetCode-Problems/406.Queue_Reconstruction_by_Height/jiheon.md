[question](https://leetcode.com/problems/queue-reconstruction-by-height/description/)

GPT helped me solve this problem


## IDEA
- We assume that input is valid
- For a taller person, the number of shorter people in front doesn't matter. 


## code/solution
- Sort people by `h` in descending order, and by `k` in ascending order.
-  Insert each person at index `k` in the result list. (If another person is already placed at that index, it will be shifted back.)
- Although this algorithm takes O(n²) time because inserting an element at a specific index in a list takes O(n), input is small(up to 2000)-so  it should be fine.


```java
class Solution {
       public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return a[1]-b[1];
        });
        List<int[]> answer = new ArrayList<>(people.length);

        for (var person : people){
            answer.add(person[1],person);
        }

        return answer.toArray(new int[0][]);
    }
}
```

```kotlin
class Solution {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        people.sortWith(compareBy({ -it[0] }, { it[1] }))
        val result = mutableListOf<IntArray>()
        for (person in people) {
            result.add(person[1], person)
        }
        return result.toTypedArray()
    }
}
```