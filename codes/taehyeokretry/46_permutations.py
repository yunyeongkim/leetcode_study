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