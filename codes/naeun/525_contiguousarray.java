class Solution {
    // ex: [0,1,1,1,1,1,0,0,0]->[-1,0,1,2,3,4,3,2,1]
    public int findMaxLength(int[] nums) {
        // 0 -> -1
        // 1 -> 1
        // if sum is zero -> it's match condition
        Map<Integer, Integer> sumIndex = new HashMap<>();
        int sum = 0;
        int answer = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == 0){
                sum--;
            } else {
                sum++;
            }
            if(sum == 0){
                answer = i+1;
            }
            sumIndex.put(sum, i);
        }

        sum = 0;
        for(int left = 0; left < nums.length; left++){
            if(nums[left] == 0){
                sum--;
            } else {
                sum++;
            }

            answer = Math.max(answer, sumIndex.get(sum) - left);
        }

        return answer;
    }
}