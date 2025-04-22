# 84. Largest Rectangle in Histogram

[problem][https://leetcode.com/problems/largest-rectangle-in-histogram/description/]

### Intuition

We need to find the largest area to solve this problem. And use **monotonic stack**. If the height of the previous block is greater than the current block, the height of the previous block become the maximum height of the rectangle.



### Method: Stack; Time: O(N)

```python
def largestRectangleArea(self, heights: List[int])->int:
    stack = [[-1, -1]]
    heights.append(0)
    ret = 0
    for i, h in enumerate(heights):
        if h >= stack[-1][1]:
            stack.append([i,h])
        else:
            while stack[-1][1] > h:
                pi, ph = stack.pop()
                ret = max(ret, (i-stack[-1][0]-1)*ph)
            stack.append([i, h])
    return ret
```

1.  **Use a stack** to store indices of bars in increasing order of height.
2.  When a bar of smaller height is encountered, **calculate the maximum area** for all indices in the stack that are greater than the current bar's height.
3.  Use a **sentinel value** of `0` height at the end to ensure all bars are processed.
4.  For each resolved height, calculate the area using the width determined by the current index and the index of the previous smaller height.