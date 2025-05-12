class Solution:
    def findMaxAverage(self, nums: list[int], k: int) -> float:
        max_avg = min(nums)
        for i in range(0, len(nums) - k + 1 ):
            window = nums[i:i + k]
            avg = sum(window) / k 
            if max_avg < avg:
                max_avg = avg
        return round(max_avg, 5) 
# Time Limit exceeded.