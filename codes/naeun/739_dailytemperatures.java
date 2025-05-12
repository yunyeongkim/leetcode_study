class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        
        for(int start = 0; start < temperatures.length; start++){
            for(int end = start+1; end < temperatures.length; end++){
                if(temperatures[start] < temperatures[end]){
                    answer[start] = end-start;
                    break;
                }
            }
        }
        
        return answer;
    }
}