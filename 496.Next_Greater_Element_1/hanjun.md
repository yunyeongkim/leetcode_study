# 496. Next Greater Element

[problem][https://leetcode.com/problems/next-greater-element-i/description/]

### Intuition

To solve this problem, we need to use stack and hash map. We will update the hash map by pushing the numbers in the list onto the stack. If the appended number is less than the next numbers in the list, that number is a hashmap of key, and the next is value.

### Method: Stack&Hash map; Time: O(N+M)

```python
def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
	stack = []
    next_greater_element = {}
    
    for num in nums2:
        while stack and stack[-1] < num:
        	next_greater_element[stack.pop()] = num
        stack.append(num)
        
    return [next_greater_element.get(num, -1) for num in nums1]
```

We use `get` method in case the number in the nums1 list is not in the hashmap. In this case, hashmap returns -1.
