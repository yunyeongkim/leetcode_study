# First trial
- submission test case failed
- At first, I wrote code just with xFirstResult, but I tried to add yFirstResult. However, it gets same result of failure.

```java
class Solution {
    private void updateMap(Map<Integer, Integer> map, int value){
        if(!map.containsKey(value)){
            map.put(value, 0);
        }
        map.put(value, map.get(value)+1);
    }
    private boolean matchesCondition(Map<Integer, Integer> map, int value){
        if(map.get(value) > 1){
            return true;
        }

        return false;
    }

    private void remove(Map<Integer, Integer> map, int value){
        map.put(value, map.get(value)-1);
    }

    public int removeStones(int[][] stones) {
        // row -> K: value(number), V: count
        Map<Integer, Integer> xCount = new HashMap<>();
        // col -> same
        Map<Integer, Integer> yCount = new HashMap<>();

        int xFirstResult = 0;

        // 1st iteration, initial and set the maps.
        for(int row = 0; row < stones.length; row++){
            int[] stone = stones[row];
            updateMap(xCount, stone[0]);
            updateMap(yCount, stone[1]);
        }

        // 2nd iteration, check if the condition matches -> reduce count value -1
        for(int row = 0; row < stones.length; row++){
            int[] stone = stones[row];
            // condition -> count > 1
            // check xCount
            if(matchesCondition(xCount, stone[0])){
                remove(xCount, stone[0]);
                xFirstResult ++;
                continue;
            }

            // check yCount
            if(matchesCondition(yCount, stone[1])){
                remove(yCount, stone[1]);
                xFirstResult ++;
            }
        }

        int yFirstResult = 0;

        // 2nd iteration, check if the condition matches -> reduce count value -1
        for(int row = 0; row < stones.length; row++){
            int[] stone = stones[row];
            if(matchesCondition(yCount, stone[1])){
                remove(yCount, stone[1]);
                yFirstResult ++;
            }

            if(matchesCondition(xCount, stone[0])){
                remove(xCount, stone[0]);
                yFirstResult ++;
                continue;
            }
        }

        return Math.max(xFirstResult, yFirstResult);
    }
}
```

# Solution with gpt help.
- The point is that count the linked group!
- it have to be dfs with linkage.

```java
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int current = 0; current < n; current++) {
            if (!visited[current]) {
                dfs(current, stones, visited);
                components++;
            }
        }

        return n - components;
    }

    private void dfs(int current, int[][] stones, boolean[] visited) {
        visited[current] = true;
        for (int target = 0; target < stones.length; target++) {
            if (!visited[target] && (stones[current][0] == stones[target][0] || stones[current][1] == stones[target][1])) {
                dfs(target, stones, visited);
            }
        }
    }
}
```

- Complexity: Time -O(n^2) , Space - O(n)