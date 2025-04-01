# solution
- time complexity: O(n*m)
```java
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
```

# Others
- what the stack does?
    - contains element's indexes of which value is greater than current. 

- time complexity : O(n+m)
```java
import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();

        int greter[] = new int[10001]; // Array to store next greater elements
        Arrays.fill(greter, -1); // Default to -1 (no greater element)

        // Traverse nums2 to find the next greater elements
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int index = stack.pop();
                greter[nums2[index]] = nums2[i];
            }
            stack.push(i);
        }

        // Map the results from nums2 to nums1
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = greter[nums1[i]];
        }
        return ans;
    }
}
```