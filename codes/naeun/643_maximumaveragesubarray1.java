class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = 0;

        int left = 0;
        double temp = 0;
        double bottom = (double) k;
        for(int i = 0 ; i < k; i++){
            temp += nums[i];
        }

        result = temp/bottom;
        for(int right = k; right < nums.length; right++){
            temp -= nums[left];
            left++;
            temp += nums[right];
            result = Math.max(result, temp/bottom);
        }


        return result;   
    }
}