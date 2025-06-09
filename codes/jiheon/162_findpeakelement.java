class Solution {
    public int findPeakElement(int[] nums) {
        int l =0, r=nums.length-1, mid=0;

        while (l < r){
            mid = (l+r)/2;

            if(nums[mid] < nums[mid+1]){
                l = mid+1;
            }else{
                r = mid;
            }
        }

        return l;
    }
}