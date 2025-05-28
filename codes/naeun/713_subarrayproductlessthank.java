class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // left // right
        int result = 0;
        int left = 0;
        long product = 1;
        for(int right = 0; right<nums.length; right++){
            product *= nums[right];
            if(product < k){
                result += right-left+1; 
            } else {
                while(product >= k && left < right){
                    product /= nums[left];
                    left++; 
                    if(product < k){
                        result += right-left+1;
                    }
                }
            }
        }

        return result;
    }
}