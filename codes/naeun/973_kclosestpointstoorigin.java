class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // priority queue
        // (value, index)
        // pop until kth.

        PriorityQueue<ValueIndex> pq = new PriorityQueue<>(Comparator.comparing(ValueIndex :: getValue));

        for(int i = 0; i < points.length; i++){
            int[] p = points[i];
            double value = Math.pow(p[0],2) + Math.pow(p[1],2);
            pq.add(new ValueIndex(value, i));
        }

        List<int[]> result = new ArrayList<>();
        for(int c = 0; c < k; c++){
            ValueIndex target = pq.poll();
            result.add(points[target.getIndex()]);
        }

        int[][] answer = new int[result.size()][2];

        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    class ValueIndex{
        double value;
        int index;

        ValueIndex(double v, int idx){
            this.value = v;
            this.index = idx;
        }

        public double getValue(){
            return value;
        }

        public int getIndex(){
            return index;
        }
    }
}