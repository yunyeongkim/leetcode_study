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