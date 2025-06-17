class Solution:
    def binary_search(self, nums: List[int], target: int, findFirst: bool) -> int:

        start, end = 0, len(nums) - 1
        result = -1

        while start <= end:
            mid = (start + end) // 2
            if nums[mid] == target:
                result = mid
                if findFirst:
                    end = mid - 1
                else:
                    start = mid + 1
            elif nums[mid] < target:
                start = mid + 1
            else:
                end = mid - 1

        return result

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first_pos = self.binary_search(nums, target, True)
        last_pos  = self.binary_search(nums, target, False)
        return [first_pos, last_pos]