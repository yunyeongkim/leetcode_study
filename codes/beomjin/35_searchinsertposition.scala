object Solution {
    def searchInsert(nums: Array[Int], target: Int): Int = {
        val lastMinPosition = nums.lastIndexWhere(_ < target)

        if (lastMinPosition == -1) {
            throw new RuntimeException("no such element")
        }

        lastMinPosition + 1
    }
}