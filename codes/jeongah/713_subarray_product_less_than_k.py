class Solution(object):
    def numSubarrayProductLessThanK(self, nums, k):
        count = 0
        end = 0
        product = 1
        
        for start in range(len(nums)):
            if end < start:
                end = start
                product = 1

            while end < len(nums):
                if product * nums[end] >= k:
                    count += end - start
                    break

                product *= nums[end]
                end += 1
            else:
                count += end - start

            product /= nums[start]

        return count