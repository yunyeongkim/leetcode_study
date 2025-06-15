

[46. Permutations](https://leetcode.com/problems/permutations/)

## IDEA

1. User DFS to visit each element.
2. During traversal, pass the visited nodes and unvisited node as arguments to the DFS function.
3. At each DFS, iterate over unvisited node, call DFS
4. When we reach the end, store the current path in result
   (end means the unvisited node is empty)




## Trial

```python
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []

        def backtrack(path, remain):
            if len(remain) == 0:
                result.append(path.copy())
                return
            for i in range(len(remain)):
                path.append(remain[i])
                backtrack(path, remain[:i] + remain[i + 1:])
                path.pop()
        backtrack([], nums)
        return result


```



## Time Complexity 
result.copy(): this takes O(n) times
remain[:i] + remain[i+1:]: this takes O(n) times 
DFS: for n elements, we travers n! times(equal to n! permutations)
So, the total time complexity is `O(n * n!)` n! permutation and O(n) work at each steps


## Space Complexity
In the result list, we have n! lists and each has length n
So, Space Complexity is `O(n * n!)`




