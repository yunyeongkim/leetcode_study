class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        
        while (l<=r){
            mid = (l+r) /2 ;

            if (nums[mid] < target){
                l  = mid + 1;
            }else{
                r = mid -1;
            }
        }

        return l;
        
    }
}