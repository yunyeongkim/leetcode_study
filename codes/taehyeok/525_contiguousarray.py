class Solution(object):
    def findMaxLength(self, nums):
        sum = 0

        dict = {0:-1}
        max_length = 0

        for index, num in enumerate(nums):
            if num == 1:
                sum += 1
            else:
                sum -= 1
            if sum in dict:
                max_length = max(max_length, index - dict[sum])
            else:
                dict[sum] = index
        return max_length



