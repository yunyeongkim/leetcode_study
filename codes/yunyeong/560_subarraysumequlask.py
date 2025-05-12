class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        arr=[]
        for i in range(len(nums)):
            temp =[]
            for j in range(i,len(nums)):
                if nums[j] <= k:
                    temp.append(nums[j])
                    if k == sum(temp):
                        arr.append(temp)
                        break
        return len(arr)

# - was not considered.