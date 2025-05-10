class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        int idx = 0;
        // iterate nums1
        for(int n1: nums1){
            // find element in nums2
            for(int i = 0; i < nums2.length; i++){
                if(nums2[i] == n1){
                    doNextGreater(i+1, n1, nums2, answer, idx);
                }
            }
            idx++;
        }

        return answer;
    }

    void doNextGreater(int start, int targetN, int[] nums2, int[] answer, int idx){
        if(start > nums2.length-1){
            answer[idx] = -1;
            return;
        }

        for(int i = start; i < nums2.length; i++){
            if(nums2[i] > targetN){
                answer[idx] = nums2[i];
                return;
            }
        }

        answer[idx] = -1;
    }
}