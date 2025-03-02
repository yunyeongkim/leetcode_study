[question link](https://leetcode.com/problems/top-k-frequent-elements/)




## IDEA
> 1.  We need to count the frequency of each unique element in array `nums`.
> 2. Create an answer array with elements that have top k frequencies.


## First code/Solution
> - There are two effective ways to count  frequency , using `array` or `map`
in this case, I expect there be many redundant elements, so I'll use a `map` .

> - After making a counter Map , we need to  find the Top `k` most frequency values.
>  So I'll sort the entries of the map and take only K keys, starting from the hightest requency .
> - There are also several ways to optimize "sorting" ( which generally takes $O(n \log n)$)
> 	- If we use `heap` of size K,  we can reduce the complexity to $O(n \log k)$  [^1] but it requires more memory.
> 	- if we use bucket sort, we can reduce the complexity to $O(n)$, but it maybe require a very large amount of memory.


```rust
use std::collections::HashMap;

impl Solution {
	pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
		let counter = nums
			into_iter()
			.fold(HashMap::new(), |mut map, num| {
				*map.entry(num).or_insert(0) += 1;
				map
			});
	
		let mut v: Vec<(i32, i32)> = counter.into_iter().collect();
		v.sort_unstable_by_key(|x| x.1);
		v.into_iter().rev().take(k as usize).map(|x| x.0).collect()
	}
}
```

| Runtime | Memory |
| ------- | ------ |
| 0ms     | 2.50MB |

It's very fast and efficent,
but it's long-winded and hard to read, even when I use lot's of method chaining to simplify it.🦀




## Why I love python  😎

```python
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        return [k for k,_ in Counter(nums).most_common(k)]
```

| Runtime | Memory  |
| ------- | ------- |
| 4ms     | 21.50MB |

it's slow and not inefficient.
but look how simple it is!


[^1]: in problem details : n>=k