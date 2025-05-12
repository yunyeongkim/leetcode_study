class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        count = 0
        for i in range(len(nums)):
            curr_sum = 0
            for j in range(i,len(nums)):
                curr_sum += nums[j]
                if curr_sum == k:
                    count += 1
        return count