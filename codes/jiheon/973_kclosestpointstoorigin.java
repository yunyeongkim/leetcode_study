class Solution {
    private final Comparator<int[]> comparator = (a, b) ->
        Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1]); 
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(comparator);

        for(int i =0; i< points.length; i++){
            pq.add(points[i]);
            if (pq.size() > k){
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];
        int i=0;
        for(var p: pq){
            ans[i++] = p;
        }
        
        return ans;
    }
}