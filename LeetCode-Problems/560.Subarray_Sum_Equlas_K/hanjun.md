# 560. Subarray Sum Equals K

[problem][https://leetcode.com/problems/subarray-sum-equals-k/description/]

### Intuition

To solve this problem, we need to know the meaning of the subarray, which is a set of adjacent elements without disconnection in a given array, and in this problem the subarray sum is equal to k. Instead of recalculating sums for all subarrays (which is inefficient), we use **prefix sums** and a **hashmap**(dictionary) to efficiently track previous sums.

### Method: Prefix sum and a hashmap; Time: O(N), Space: O(N)

```python
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
```

The key point is total - k. The prefix sum at index j is the cumulative sum of all elements from index to j. The sum of any subarray index i to j can be expressed as:`subarray_sum = prefix_sum[j] - prefix_sum[i-1]`

Setting this equal to k: `k = prefix_sum[j] - prefix_sum[i-1]` 

&rarr; which can be rearranged to: `prefix_sum[i-1] = prefix_sum[j] - k

This means if prefix_sum[i-1] exists in our hashmap of previous prefix sums, then a valid subarray ending at j exists.

