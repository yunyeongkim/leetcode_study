class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        number, count = nums[0], 1

        for e in nums[1:]:
            if e == number:
                count += 1
            else:
                if count == 0:
                    number = e
                else:
                    count -= 1
        return number