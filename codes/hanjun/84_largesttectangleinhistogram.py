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