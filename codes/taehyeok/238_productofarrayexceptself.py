class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        result = [1] * len(nums)
        left_product = 1
        right_product = 1
        for i in range(len(nums)):
            result[i] *= left_product
            left_product *= nums[i]
        for i in range(len(nums) - 1, -1, -1):
            result[i] *= right_product
            right_product *= nums[i]
        return result

