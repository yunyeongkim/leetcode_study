# solution
## trial -> failed

```java
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
```

## look for other solution (couldn't solved)
- logically, to make maxArea, it is going to change if height decreases. We are going to keep increasing heights in stack.
- stack deal with previous height so that we have to deal with previous ones. if current is going to decreasing, we are going to use stack elements before pushing current elements.
- stack contains increasing heights because we are going to pop the elements when it started to decrease.

```text
h: [2,1,5,6,0,7]

iteration---
idx: 0 (start)
- currH = 2;
- not go into while because stack is empty.
- stack: [0]

idx: 1 (decreasing), currH = 1;
- stack: [0]
- go into while because previous height is greater than now;
    - stackH: 2 (previous one)
    - w: stack is empty -> 1
- stack: [1]

idx: 2 (increasing), currH = 5
- not go into while loop because it is increasing.
- stack: [1, 2]

idx: 3 (increasing), currH = 6
- Not while
- stack: [1,2,3]

idx: 4 (decreasing), currH = 0
- while loop
    - stackH = 6, stack: [1,2], w = (4 -1: 6인 높이의 인덱스) - 2 (5인 높이의 인덱스) = 1,  h*w = 6
    - stackH = 5, stack : [1], w = (4-1: 6인 높이의 인덱스) - 1 (1인 높이의 인덱스) = 2,  h*w = 10
    - stackH = 1, stack: [], w = 4 (stack 비어짐, 처음부터 현재까지),  h*w = 4
- stack: []

idx: 5 (increasing), currH = 7
- not while
- stack: [5]

idx: 6 (out of index), currH = 0
- while 
    - stackH = 0, stack: [], w = 6, h*w = 0
```
```java
import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
```