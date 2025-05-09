It's interesting that I solved this problem before.

On April 2, 2023, my submission was accepted.

```python
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        counter = Counter(nums)
        print(counter.most_common(1))
        return counter.most_common(1)[0][0]

```

However, it was clear that this solution did not align with the intended challenge of the problem.

I'm glad that I can now solve it under the given constraints.

Initially, I couldn't believe it was possible to solve this problem with O(1) space complexity. Considering the constraints, the solution must be achievable in O(n) or O(n log n) time complexity, since the maximum number of elements in the array is 5 \* 10^4.

If I attempted to solve it with an O(n²) approach using nested loops, it would require 2.5 billion reads, which is impractical.

At first, I considered a stochastic approach, such as randomly selecting 10 samples and counting the occurrences, relying on the probability that the most common element would appear within a certain range based on the binomial probability theorem. However, I realized that this approach would not be accepted.

There had to be a more clever solution.

Then, I came up with an analogy: I could treat the numbers like armies from different countries.

If an army encounters an ally (a number with the same value) next to it, they join forces.

If the numbers are different, they fight and both decrease in strength.

This idea led me to the following algorithm, which represents this process:

```python
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

```

This solution efficiently finds the majority element with O(n) time complexity and O(1) space complexity.

We can simulate if this greedy solution can actually solve each edge cases.

Like,

```jsx
1 1 1 1 1 2 2 2 2

2 2 2 2 1 1 1 1 1

1 2 1 2 1 2 1 2 1
```

It turns out the above algorithm works for all three extreme cases.
