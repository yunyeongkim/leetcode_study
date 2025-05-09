class RecentCounter {

    private final Deque<Integer> q = new ArrayDeque<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        while (q.peekFirst() != null && q.peekFirst() < t - 3000) {
            q.pollFirst();
        }
        q.addLast(t);
        return q.size();
    }
}