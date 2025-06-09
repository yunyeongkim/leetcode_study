## First Try

```go
func searchRange(nums []int, target int) []int {

    found := false;
    for _, value := range nums {
        if value == target {
            found = true
            break
        }
    }

    if !found {
        return []int{-1, -1}
    }

    return []int{0, 0}

}
```

As soon as I read the problem I knew I was wrong since I needed to figure this out in O(log n).

## Second Try

## Second try

```go
package main

import "fmt"

func searchRange(nums []int, target int) []int {
    // TODO: Implement your solution here
    // Requirements:
    // - Find starting and ending position of target in sorted array
    // - Return [-1, -1] if target not found
    // - Must be O(log n) time complexity

    if len(nums) == 0 {
        return []int{-1, -1}
    }

    fmt.Println("Searching for target:", target)
    fmt.Printf("In array nums = %v\n", nums)

    leftIdx := binarySearchLeft(nums, 0, len(nums), target)
    if leftIdx == -1 {
        return []int{-1, -1}
    }

    rightIdx := binarySearchRight(nums, 0, len(nums), target)

    return []int{leftIdx, rightIdx}
}

/*
if the nums[mid] is larger than target, then we should search the left side.
If the nums[mid] is smaller than target, then we should search the right side.
if the numbs[mid] is equal to target, we need to check if it is the first occurrence.
so we go to the left side, including the index of itself.
*/
func binarySearchLeft(nums []int, start int, end int, target int) int {
    mid := start + end>>1
    println("binarySearchLeft start, end, mid, target", start, end, mid, target)

    if end-start <= 1 {
        if nums[mid] == target {
            println("found!")
            return start
        } else {
            return -1
        }
    }

    println("binarySearchLeft nums[mid]", nums[mid])

    if nums[mid] >= target {
        return binarySearchLeft(nums, start, mid, target)
    } else {
        return binarySearchLeft(nums, mid, end, target)
    }
}

/*
if the nums[mid] is larger than target, then we should search the left side.
If the nums[mid] is smaller than target, then we should search the right side.
if the numbs[mid] is equal to target, we need to check if it is the last occurrence.
so we go to the right side, including the index of itself.
*/
func binarySearchRight(nums []int, start int, end int, target int) int {
    mid := (start + end) >> 1
    println("binarysearchRight start, end, mid, target", start, end, mid, target)

    if end-start <= 1 {
        if nums[mid] == target {
            println("found target! returning start index", start)
            return start
        } else {
            return -1
        }
    }

    println("binarySearchRight nums[mid]", nums[mid])

    if nums[mid] <= target {
        return binarySearchRight(nums, mid, end, target)
    } else {
        return binarySearchRight(nums, start, mid, target)
    }
}

func main() {
    // Test cases
    testCases := []struct {
        nums     []int
        target   int
        expected []int
    }{
        {[]int{5, 7, 7, 8, 8, 10}, 8, []int{3, 4}},
        {[]int{5, 7, 7, 8, 8, 10}, 6, []int{-1, -1}},
        {[]int{}, 0, []int{-1, -1}},
        {[]int{1}, 1, []int{0, 0}},
        {[]int{2, 2}, 2, []int{0, 1}},
        {[]int{1, 2, 3}, 2, []int{1, 1}},
    }

    fmt.Println("Testing searchRange function:")
    fmt.Println("============================")

    for i, tc := range testCases {
        result := searchRange(tc.nums, tc.target)
        passed := slicesEqual(result, tc.expected)

        fmt.Printf("Test %d: ", i+1)
        if passed {
            fmt.Printf("PASS")
        } else {
            fmt.Printf("FAIL")
        }
        fmt.Printf("\n")
        fmt.Printf("  Input:    nums=%v, target=%d\n", tc.nums, tc.target)
        fmt.Printf("  Expected: %v\n", tc.expected)
        fmt.Printf("  Got:      %v\n", result)
        fmt.Println()
    }
}

// Helper function to compare slices
func slicesEqual(a, b []int) bool {
    if len(a) != len(b) {
        return false
    }
    for i := range a {
        if a[i] != b[i] {
            return false
        }
    }
    return true
}

```

Kind of messy.

## Third Try

```go
func searchRange(nums []int, target int) []int {
    left := insertionIndex(nums, target, false)
    if left == len(nums) || nums[left] != target {
        return []int{-1, -1}
    }
    right := insertionIndex(nums, target, true) - 1
    return []int{left, right}
}

// Returns the insertion index for target
// If rightBias is false -> lower_bound (first index where nums[i] >= target)
// If rightBias is true  -> upper_bound (first index where nums[i] > target)
func insertionIndex(nums []int, target int, rightBias bool) int {
    left, right := 0, len(nums)
    for left < right {
        mid := (left + right) / 2
        if nums[mid] > target || (!rightBias && nums[mid] == target) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}
```

Why does this work?

---

## 🧠 Problem Summary

We are given a **sorted array** of integers, like:

```
[5, 7, 7, 8, 8, 10]
```

We are asked to **find the starting and ending position** of a number in the array.

For example:

```go
target = 8
output = [3, 4]  // because 8 appears from index 3 to 4
```

If the number is not in the array, we should return `[-1, -1]`.

We are told to solve this **efficiently in O(log n)** time, which means we should **not** use a loop from start to end. Instead, we must use **binary search**.

---

## 📌 What is Lower Bound and Upper Bound?

These are two important ideas for searching in sorted arrays.

### 🔽 Lower Bound

The **first index** where the number is **greater than or equal to** the target.

Example:

```go
nums = [2, 4, 4, 4, 7]
target = 4

lower bound of 4 = index 1  // first place where 4 appears
```

### 🔼 Upper Bound

The **first index** where the number is **strictly greater than** the target.

Example:

```go
nums = [2, 4, 4, 4, 7]
target = 4

upper bound of 4 = index 4  // this is where 7 appears
```

So if you want to find the **last index where 4 appears**, it’s `upper_bound - 1`, which is `4 - 1 = 3`.

---

## 🛠️ How Do We Use This to Solve the Problem?

We just need to:

1. Use **lower bound** to find the first index of the target
2. Use **upper bound** to find the index _after_ the last occurrence
3. Subtract 1 from the upper bound to get the last occurrence

If the lower bound gives us an index that's out of range or not equal to the target, then the target is not in the array.

---

## ✅ Full Code Again (For Reference)

```go
func searchRange(nums []int, target int) []int {
    left := insertionIndex(nums, target, false) // lower_bound
    if left == len(nums) || nums[left] != target {
        return []int{-1, -1}
    }
    right := insertionIndex(nums, target, true) - 1 // upper_bound - 1
    return []int{left, right}
}

// Insertion index finder
// If rightBias is false → lower bound
// If rightBias is true  → upper bound
func insertionIndex(nums []int, target int, rightBias bool) int {
    left, right := 0, len(nums)
    for left < right {
        mid := (left + right) / 2
        if nums[mid] > target || (!rightBias && nums[mid] == target) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}
```

---

## 🧑‍🏫 How to Teach It

Here’s a classroom-ready summary:

| Term          | Meaning                                                | Code Logic                 |
| ------------- | ------------------------------------------------------ | -------------------------- |
| Lower Bound   | First position where `nums[i] >= target`               | `!rightBias` case          |
| Upper Bound   | First position where `nums[i] > target`                | `rightBias` case           |
| Search Range  | `[lower_bound, upper_bound - 1]` if target is present  | check bounds, subtract one |
| Binary Search | Cuts search space in half to find position efficiently | `O(log n)`                 |
