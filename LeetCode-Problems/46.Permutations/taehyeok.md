

[46. Permutations](https://leetcode.com/problems/permutations/)

## IDEA

1. At each DFS step, we move 1 element from the `nums` list to the `permutation` list. 
   (by iterating over all elements in `nums`)
2. After moving the element to permutation list, delete that same element from the `num` list.
   (rename the updated `nums` list to 'remain' list)
3. If all elements have been moved from the `remain` list, append the `permutation` to the `answer` list.


## Trial

```python
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        answer = []
        def DFS(permutation: List[int], remain: List[int]):
            if not remain:
                return answer.append(permutation)
            for i in range(len(remain)):
                newResult = permutation.copy()
                newResult.append(remain[i])
                newRemain = remain[:i] + remain[i+1:]
                DFS(newResult, newRemain)

        DFS([], nums)
        return answer
```



## Time Complexity 
result.copy(): this takes O(n) times
remain[:i] + remain[i+1:]: this takes O(n) times 
DFS: for n elements, we travers n! times(equal to n! permutations)
So, the total time complexity is `O(n * n!)` n! permutation and O(n) work at each steps


## Space Complexity
In the result list, we have n! lists and each has length n
So, Space Complexity is `O(n * n!)`




