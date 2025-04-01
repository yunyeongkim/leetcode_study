# solution

## trial1 -> timeout
- time: O(n^2)
```java
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
```

## trial2
- with hint: stack
    - stack holds index which are smaller than current. if it matches the condition, the difference between indexes will be the answer.

- time complexity: O(n+m)
```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int prevIdx = stack.pop();
                answer[prevIdx] = i-prevIdx; // length
            }
            stack.push(i);
        }
        
        return answer;
    }
}
```
