class Solution:

    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        num1Idx = {n:i for i,n in enumerate(nums1)}
        res = [-1] * len(nums1)
        stack = []

        for i in range(len(nums2)):
            cur = nums2[i]
            while stack and cur > stack[-1]:
                val = stack.pop()
                idx = num1Idx[val]
                res[idx] = cur 
            if cur in num1Idx:
                stack.append(cur)
        return res

# 52%