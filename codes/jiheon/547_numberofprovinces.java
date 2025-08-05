class Solution {
    public int findCircleNum(int[][] isConnected) {
        var uf = new UF(isConnected.length);
        for(int i =0 ; i<isConnected.length; i++){
            for(int j=i+1; j<isConnected.length; j++){
                if (isConnected[i][j] == 1 ){
                    uf.union(i,j);
                }
            }
        }

        return IntStream.range(0,isConnected.length)
            .boxed()
            .map(uf::find)
            .collect(Collectors.toSet())
            .size();
    }

    static class UF {
        private int[] parents;
        private int[] rank;

        public UF(int size) {
            this.parents = new int[size];
            this.rank = new int[size];
            for (int i = 0; i < size; i++) {
                parents[i] = i;
            }
        }

        public int find(int x) {
            if (parents[x] == x) {
                return x;
            }
            parents[x] = find(parents[x]); 
            return parents[x];
        }

        public void union(int x, int y){
            int xParent = find(x);
            int yParent = find(y);
            if (xParent == yParent){
                return;
            }

            if(rank[xParent] == rank[yParent]){
                parents[yParent] = xParent;
                rank[xParent]++;
            }else if (rank[xParent] < rank[yParent]){
                parents[xParent] = yParent;
            }else{
                parents[yParent] = xParent;
            }
        }
    }
}