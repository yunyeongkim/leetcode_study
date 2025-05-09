class Solution:
    def runningSum(self, nums: list[int]) -> list[int]:
        arr = []
        arr.append(nums[0])
        for i in range(1,len(nums)):
            arr.append(arr[i-1]+nums[i])
        return arr
# O(n)