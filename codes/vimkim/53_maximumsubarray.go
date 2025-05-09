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