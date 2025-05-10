def runningSum(self, nums: List[int]) -> List[int]:
    for i in range(1,len(nums)):
        nums[i] = nums[i-1] + nums[i]						# nums[0] is same as runningSum[0]
    return nums