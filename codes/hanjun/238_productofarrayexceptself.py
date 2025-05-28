class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        output = [1] * n

        for i in range(1, n):
            output[i] = output[i-1] * nums[i-1]
        
        right = 1
        for i in reversed(range(n)):
            output[i] *= right
            right *= nums[i]
        
        return output