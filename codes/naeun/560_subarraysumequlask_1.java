class Solution {

    public int subarraySum(int[] nums, int k) {
        // answer is total num of subarrays whose sum == k
        int answer = 0;

        // dp sum of arrays & count
        Map<Integer, Integer> sumAndCount = new HashMap<>();
        int presum = 0;
        for(int n: nums){
            presum += n;
            
            // itself
            if(presum == k){
                answer++;
            }

            // subarray
            if(sumAndCount.containsKey(presum-k)){
                answer += sumAndCount.get(presum-k);
            }

            sumAndCount.put(presum, sumAndCount.getOrDefault(presum, 0) +1);
        }

        // return answer
        return answer;
    }

}