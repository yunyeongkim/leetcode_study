# Question
[802. Find Eventual Safe States](https://leetcode.com/problems/find-eventual-safe-states/description/)

The goal is to find all the safe nodes, which every path leads to a terminal node.
It means that we want to identify nodes that are not cycle.

# Idea
- Paths starting from safe nodes always end at terminal nodes.
- Therefore, We can start from terminal nodes and work backwards to mark safe nodes.
- This can be using `Topological Sort`

# Topological Sort
Topological Sort is a way to order tasks when some tasks must be done before others.
It only works for grpahs without cycles.

To find nodes not involved in cycles, we perform a reverse topological sort starting from terminal nodes.
Terminal nodes are always safe since they have no outgoing edges (no cycles).

We keep track of each node's outdegree count (number of outgoing edges).
If the count becomes 0, it indicates that node becomes the terminal node, so we remove the node and store it as safe node.

# Code
```swift
class Solution {
    func eventualSafeNodes(_ graph: [[Int]]) -> [Int] {
        var reserveGraph = Array(repeating: [Int](), count: graph.count)
        var outdegrees = Array(repeating: 0, count: graph.count)
        var queue = [Int]()

        for (index, nodes) in graph.enumerated() {
            if nodes.isEmpty {
                queue.append(index)
                continue
            }

            outdegrees[index] = nodes.count
            for outNode in nodes {
                reserveGraph[outNode].append(index)
            }
        }

        var result = [Int]()
        while !queue.isEmpty {
            let node = queue.removeFirst()
            result.append(node)

            for inNode in reserveGraph[node] {
                outdegrees[inNode] -= 1
                if outdegrees[inNode] == 0 {
                    queue.append(inNode)
                }
            }
        }

        return result.sorted()
    }
}
```

# Complexity
- Time: O(V + E)
- Space: O(V + E)
V is the number of nodes, E is the number of edges.