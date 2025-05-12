def subarraySum(self, nums: List[int], k: int) -> int:
    subarray_sum = defaultdict(int)
    ans, prefix_sum = 0, 0
    subarray_sum[0] = 1
    
    for num in nums:
        prefix_sum += num
        if prefix_sum - k in subarray_sum:
            ans += subarray_sum[prefix_sum - k]
        subarray_sum[prefix_sum] += 1
    
    return ans