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