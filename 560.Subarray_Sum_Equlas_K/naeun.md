# solution

## trial1
- timeComplexity: O(n^2): 1588ms, Beats 5.02%
- spaceComplexity: O(1)
```java
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
```

## with other's solution
- keep prefixsum with map
- timeComplexity: O(n)
- spaceComplexity: O(n)

```java
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
```
