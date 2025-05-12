def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
	stack = []
    next_greater_element = {}
    
    for num in nums2:
        while stack and stack[-1] < num:
        	next_greater_element[stack.pop()] = num
        stack.append(num)
        
    return [next_greater_element.get(num, -1) for num in nums1]