class Solution {
    public int[] runningSum(int[] nums) {
        // result is fixed-size array
        int[] result = new int[nums.length];

        // totalSum cache
        int sum = 0;

        // iterate and update result
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            result[i] = sum;
        }

        // return result
        return result;
    }
}