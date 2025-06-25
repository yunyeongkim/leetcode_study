class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (var s : stones) {
            pq.add(s);
        }
        while (pq.size() > 1) {
            var y = pq.poll();
            var x = pq.poll();
            if (x != y) {
                pq.add(y - x);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}