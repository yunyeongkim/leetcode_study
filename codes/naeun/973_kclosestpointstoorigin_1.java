class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // 최대 힙 (거리 기준으로 내림차순)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distance(b), distance(a))
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // 가장 먼 점 제거
            }
        }

        // 결과 배열로 변환
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    // 제곱 거리만 비교하면 충분 (루트 안 씌워도 됨)
    private int distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}