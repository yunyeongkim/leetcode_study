class Solution {

    public int subarraySum(int[] nums, int k) {
        // answer is total num of subarrays whose sum == k
        int answer = 0;

        int rightSum = 0;
        for(int right = 0; right< nums.length; right++){
            rightSum += nums[right]; 
            
            int totalSum = rightSum;
            for(int left = 0; left <= right; left ++){
                if(totalSum == k){
                    answer += 1;
                }
                totalSum -= nums[left];
            }
        }
        // return answer
        return answer;
    }

}