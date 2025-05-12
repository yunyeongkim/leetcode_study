class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        return [k for k,_ in Counter(nums).most_common(k)]