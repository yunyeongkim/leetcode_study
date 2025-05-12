class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = heights[0]; // width * min height
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] <= heights[i]){
                int prevIdx = stack.pop();
                result = Math.max((i-prevIdx+1) * heights[prevIdx], result);
            }
            result = Math.max(result, heights[i]);
            stack.push(i);
        }

        return result;
    }
}