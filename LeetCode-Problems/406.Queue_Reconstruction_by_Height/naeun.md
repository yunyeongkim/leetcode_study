# could't solve

- searched for other's solution
- time comlexity: O(nlogn)
```java
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if(a[0] - b[0] == 0) {
                return a[1] - b[1];
            } 
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();
        for(int[] person: people){
            result.add(person[1], person);
        }

        int[][] answer = new int[people.length][2];
        
        for(int i = 0; i < people.length; i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}
```