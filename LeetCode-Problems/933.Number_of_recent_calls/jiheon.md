[problem](https://leetcode.com/problems/number-of-recent-calls/)


## Solution
- Use "deque" data structure to keep track of recent ping times.
- Each time `ping(t)` is called, add `t` to the end of the  deque  and remove elements from the front  until the  first element is greater than or  equal to `t - 3000`.


```java
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
```

```kotlin
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
```
