class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1, result = 0, left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (left <= right && product >= k) {
                product /= nums[left];
                left++;
            }

            result += right - left + 1;
        }

        return result;
    }
}