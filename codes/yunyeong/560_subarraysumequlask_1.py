class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        arr=[]
        for i in range(len(nums)):
            temp =[]
            for j in range(i,len(nums)):
                temp.append(nums[j])
                if k == sum(temp):
                    arr.append(temp)
        return len(arr)
# time limit exceeded due to duplicated search.