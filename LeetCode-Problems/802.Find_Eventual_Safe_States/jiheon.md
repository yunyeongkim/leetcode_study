[problem](https://leetcode.com/problems/find-eventual-safe-states/)

## IDEA
We use a DFS-based approach to traverse the graph.  
To avoid redundant operations and detect cycles, we mark each node during the traversal.


## Solution
Each node can be in one of three states: not visited, unsafe, or safe.

Traversing a node with DFS
- When we visit a node, first mark as unsafe.
- Recursively check all  its adjacent nodes. If all of them are safe, mark it as safe. Otherwise, it remains unsafe.


```python
class Solution:

    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        visited = [-1] * n  # -1 unvisited , 0 visitied , 1 safe
        ans = []

        def dfs(i: int) -> bool:
            if visited[i] != -1:
                return visited[i]
            visited[i] = 0
            for next_node in graph[i]:
                if dfs(next_node) == 0:
                    return 0
            visited[i] = 1
            return 1

  
        for i in range(n):
            if dfs(i):
                ans.append(i)
        return ans
```