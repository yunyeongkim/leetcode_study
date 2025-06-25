[problem](https://leetcode.com/problems/k-closest-points-to-origin/description/)

## Idea
- The most straightforward approach is to sort the array and return the K closest points. 
  This approach has a time complexity of $O(n\log n)$.
- We can reduce the time complexity to $O(n\log k)$ by using a max heap of size $k$.
- The formula for Euclidean distance is $\sqrt{(x_1 - x_2)^2 + (y_1 - y_2)^2}$, but we don't the need exact distance. So we can just use $x^2 + y^2$ instead.

## Code/Solution
- For each iteration, add the current point to the heap.
- If the heap size is greater than k, remove the largest element(This takes O($\log k$) time).
```java
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
```

## Optimize more
- We can cache each point's distance.
   This will use more memory, but It speed things up.

- The most optimized solution is to apply QuickSelect.  
  If you're interested, I’ll leave a [link](https://leetcode.com/problems/k-closest-points-to-origin/solutions/1578232/all-possible-3-python-solutions-interviewer-expectations/) for you.