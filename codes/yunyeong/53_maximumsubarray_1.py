class Solution:
    def maxSubArray(self, nums: List[int]) -> int:            
        res = nums[0]  # 최댓값 저장 (초기값: 첫 번째 요소)
        total = 0  # 현재까지의 합

        for n in nums:
            if total < 0:
                total = 0  # 음수라면 리셋 (새로운 부분 배열 시작)

            total += n  # 현재 숫자를 더함
            res = max(res, total)  # 최댓값 갱신
        
        return res