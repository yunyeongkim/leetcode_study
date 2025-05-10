class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        counter = Counter(nums)
        print(counter.most_common(1))
        return counter.most_common(1)[0][0]