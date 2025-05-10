class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_table = Counter(nums)
        heap = []
        for i in freq_table.keys():
            heappush(heap, (-freq_table[i], i))
        ans = []
        while k > 0:
            k -= 1
            ans.append(heappop(heap)[1])
        return ans
# O(NLogN) / O(n)