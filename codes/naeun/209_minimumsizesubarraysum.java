class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;

        // do double iteration 
        // if sum matches target, update result with min value
        for(int left = 0; left < nums.length; left++){
            int temp = 0;
            for(int right = left; right < nums.length; right++){
                temp += nums[right];

                if(temp >= target){
                    result = Math.min(result, right-left+1);
                    break;
                }
            }
        }

        if(result == Integer.MAX_VALUE){
            return 0;
        }
        return result;
    }
}