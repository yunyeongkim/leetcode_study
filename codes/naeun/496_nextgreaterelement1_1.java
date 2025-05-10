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