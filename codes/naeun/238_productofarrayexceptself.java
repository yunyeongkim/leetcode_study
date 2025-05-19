class Solution {
    public int[] productExceptSelf(int[] nums) {

        int extendedLength = nums.length+2;
        int[] fromLeft = new int[extendedLength];
        fromLeft[0] = 1;
        fromLeft[extendedLength-1] = 1;
        for(int i = 0; i < nums.length; i++){
            fromLeft[i+1] = fromLeft[i] * nums[i];
        }

        int[] fromRight = new int[extendedLength];
        fromRight[0] = 1;
        fromRight[extendedLength-1] = 1;
        for(int i = nums.length-1; i >=0; i--){
            fromRight[i+1] = nums[i] * fromRight[i+2];
        }

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = fromLeft[i] * fromRight[i+2];
        }

        return result;
    }
}