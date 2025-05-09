class RecentCounter() {

    private val q = ArrayDeque<Int>()

    fun ping(t: Int): Int {
        while (q.firstOrNull()?.let { it < t - 3000 } == true) {
            q.removeFirst()
        }
        q.add(t)
        return q.size
    }

}