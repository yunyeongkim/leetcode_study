# [35. Search Insert Position](https://leetcode.com/problems/search-insert-position)

## Problem Analysis
- Input array is already sorted and has distinct integers.
- So just find LTE condition value, that may be the near position of inserting
- I try to use `lastIndexWhere` to find the last position of the element that is less than the target value.

## Code

```scala
object Solution {
    def searchInsert(nums: Array[Int], target: Int): Int = {
        val lastMinPosition = nums.lastIndexWhere(_ < target)

        if (lastMinPosition == -1) {
            throw new RuntimeException("no such element")
        }

        lastMinPosition + 1
    }
}
```

## Code Analysis
- Actually, use binary-search is the best solution of this problem.
- But I misunderstood which problem I was supposed to solve so timeless.