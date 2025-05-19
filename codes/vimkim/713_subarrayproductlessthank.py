class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:

        cnt = 0
        L = len(nums)
        l = 0
        r = 0
        prod = 1

        if k <= 1:
            return 0

        for r in range(L):

            prod *= nums[r]

            while prod >= k:
                prod //= nums[l]
                l += 1

            cnt += r - l + 1
        return cnt