class Solution:

	def merge(self, nums1: list[int], m: int, nums2: list[int], n: int) -> None:
		if n == 0:
			return None
		for i in range(m, m+n):
			nums1[i] = nums2[m-i]
			nums1.sort()
# 100% beats.