k 25

1 2 3 4 5 4 3 2 1 2 3 4 5

1 -> 1
2 -> 3
3 -> 6 3!

then if 5 is included,
you must advance

but what if

1 2 3 4 5 4 3 2 1 2 3 4 5
1 2 3 4 5 4 3 2 1 2 3 4 5

No...

```python
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

```
