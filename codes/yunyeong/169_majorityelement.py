class Solution(object):
    def majorityElement(self, nums):
        flag = int(len(nums)/2)
        counter = {}
        for num in nums:
            if num in counter:
                counter[num] += 1
            else:
                counter[num] = 1
            if counter[num] > flag:
                return num
        return None
# O(n) / O(n) .