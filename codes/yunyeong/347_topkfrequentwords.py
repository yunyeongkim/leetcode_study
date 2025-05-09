class Solution(object):
    def topKFrequent(self, nums, k):
        frequent = { }
        for num in nums:
            if num in frequent:
                frequent[num] += 1
            else:
                frequent[num] = 1
        sorted_frequent = sorted(frequent.items(), key=lambda x: x[1],reverse=True)
        arr = []
        for num in sorted_frequent:
            if len(arr) == k:
                return arr
            else:
                arr.append(num[0])
        return arr
# O(NLogN) / O(n)