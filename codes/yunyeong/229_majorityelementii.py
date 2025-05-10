class Solution(object):
    def majorityElement(self, nums):
        flag = int(len(nums)/3)
        counter = {}
        arr = []
        for num in nums:
            if num in arr:
                continue
            if num in counter:
                counter[num] += 1
            else:
                counter[num] = 1
            if counter[num] > flag:
                arr.append(num)
        return arr
# O(n) / O(n) - Dict