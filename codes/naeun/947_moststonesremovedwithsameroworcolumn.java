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