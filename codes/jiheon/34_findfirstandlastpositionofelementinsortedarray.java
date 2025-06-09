class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0,r=nums.length-1,mid=0;
        int[] answer = {-1,-1};
        if (r == -1) return answer;
        //lower bound
        while (l<=r){
            mid = (l+r)/2;
            if (nums[mid] < target){
                l = mid+1;
            }else{
                r = mid -1;
            }
        }

        if (l >=nums.length || nums[l] != target){
            return  answer;
        }else{
            answer[0] = l;
        }

        r = nums.length-1;

        //upper bound
        while (l<=r){
            mid = (l+r) /2;
            if (nums[mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        answer[1] =r ;

        return answer;
    }
}