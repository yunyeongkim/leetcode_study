> [! question]+
> Given an integer array `nums` and an integer `k`, return _the_ `k` _most frequent elements_. You may return the answer in **any order**.
> > [!example]+
> > **Input:** nums = [1,1,1,2,2,3], k = 2
> >**Output:** [1,2]
>
>> [!example]+
>> **Input:** nums = [1], k = 1
>>**Output:** [1]

>[!note] Definition
>- K most frequent elements -> was ambiguous when I first saw it.
>- K most frequent elements means, [1,1,2,2,2,3,3,3,4,4,4,4]
>-  -> 1 Most frequent = 4
>- -> 2 Most frequent = 3,4
>- -> 3 Most frequent = 2,3,4
>- -> 4 Most frequent = 1,2,3,4
>

### First Code : 15 min
```python
class Solution(object):
    def topKFrequent(self, nums, k):
        frequent = { }
        for num in nums:
            if num in frequent:
                frequent[num] += 1
            else:
                frequent[num] = 1
        sorted_frequent = sorted(frequent.items(), key=lambda x: x[1],reverse=True)
        arr = []
        for num in sorted_frequent:
            if len(arr) == k:
                return arr
            else:
                arr.append(num[0])
        return arr
# O(NLogN) / O(n)
```

### Solution Code:
```python
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
```

