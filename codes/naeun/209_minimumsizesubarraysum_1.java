class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        // if sum matches target, update result with min value
        int left = 0;
        int right = left;
        int temp = nums[right];
        // do one iteration with using left index and right index.
        while(left < nums.length && right < nums.length){
            if(target <= temp){
                // else increase left
                result = Math.min(result, right-left+1);
                temp -= nums[left];
                left++;
            } else {
            // increase right if sum < target
                right++;
                if(right >= nums.length){
                    break;
                }
                temp += nums[right];
            }

        }
        if(result == Integer.MAX_VALUE){
            return 0;
        }
        return result;
    }
}