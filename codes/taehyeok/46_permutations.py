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