[problem](https://leetcode.com/problems/last-stone-weight/description/)

## Idea
- If we sort the stones every time a smash happens, it takes $O(n \log n)$ time complexity per operation.
- Instead, we can use a heap data strucutre. which reduces the each operation  to $O(\log n)$ time complexity

##  Code and Solution
- The code is quite simple. Just keep smashing the two heaviest stones until there is only one or zero stone left in the heap.

```java
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
```