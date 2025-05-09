At first, I thought this was a dynamic programming (DP) problem.

Given the time complexity constraint of either \(O(n)\) or \(O(n \log n)\), I knew the solution had to involve either **DP with memoization** or a **heap/binary search approach**.

However, I recalled solving a very similar problem before and remembered that the optimal solution runs in **\(O(n)\)**. Unfortunately, I couldn’t immediately recall the exact algorithm or approach.

After revisiting the problem many days later, I realized that this is, in fact, a **greedy algorithm** problem.

### Breaking the Problem Down

To approach this problem, I divided it into several smaller subproblems with **local solutions**:

1. **What if the solution must start from index \(i\)?**
2. **What if the solution must end at index \(j\)?**

Interestingly, the local solutions to these two questions **never overlap**—and if they do, they must be the same solution.

### Proof by Contradiction

If the solution to the **first** subproblem overlaps with the solution to the **second**, then it is always more beneficial to **expand the answer** to include the solution at \(j\). This means that the local solutions must always remain **separate**.

The key insight is that, at every step, we must decide **whether to merge with the neighboring solution or start anew**.

### The Greedy Approach

At each index, we have two choices:

- **Start a new subarray** at the current index.
- **Extend the existing subarray** by including the current element.

This leads to the following recurrence relation:

$$
\text{max}(\text{start a new subarray}, \text{extend the current subarray})
$$

So my final answer is the following:

```go
func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}

func maxSubArray(nums []int) int {
    maxSum := nums[0]
    currentSum := nums[0]

    for i := 1; i < len(nums); i++ {
        currentSum = max(nums[i], currentSum+nums[i])
        maxSum = max(maxSum, currentSum)
    }

    return maxSum
}
```
