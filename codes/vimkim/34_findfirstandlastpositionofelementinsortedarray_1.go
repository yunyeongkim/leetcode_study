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