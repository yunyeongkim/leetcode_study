
# IDEA
1. Pick the middle element of the array.
2. If the middle element is equal to the target, return its index.
3. If target < nums[middle], search the left half of the array. (Pick the left half)
4. If target > nums[middle], search the right half of the array. (Pick the right half)
5. Until the left pointer and the right pointer meet, repeat steps 1-4.
6. After the loop ends, return the left pointer as the insertion index (this is where target belongs).

---

## How to find the middle element?

- **Compute middle**

  ```
  middle = (left + right) // 2
  ```
  - odd length: middle is the exact middle index.
  - even length: middle is the left of the two middle indices.
    (using rounding down)
  
---

## Case 1) target = 5, nums = [1, 3, 5, 6]

### 1st iteration:

| 1   | 3   | 5     | 6 |
|-----|-----|-------|---|
| l   | m   |       | r |

`target(5) > middle element(3)`

=> pick the right half

### 2nd iteration:

|1 | 3| 5   | 6 |
|---|---|-----|---|
|   |   | l   | r |


|1 | 3| 5     | 6 |
|---|---|-------|---|
|   |   | l = m | r |

`m = (l + r) // 2 = (2 + 3) // 2 = 2`

`target(5) == middle element(5)`

=> return 2(index of 5 in nums)

## Case 2) target = 2, nums = [1, 3, 5, 6]

### 1st iteration:

| 1 | 3 | 5   | 6 |
|---|---| --- |---|
| l | m |     | r |

`target(2) < middle element(3)`

=> pick the left half

### 2nd iteration:

| 1    | 3| 5   | 6 |
|------|--|-----|---|
| l, r | |     |   |


| 1         | 3| 5   | 6 |
|-----------|--|-----|---|
| l = m = r | |     |   |

`target(2) > middle element(1)`

=> pick the right half

### 3rd iteration:

| 1 | 3 | 5   | 6 |
|---|---|-----|---|
| r | l |     |   |

left > right, so we exit the loop.

return `l (1)` as the insertion index.


## Case 3) target = 7, nums = [1, 3, 5, 6]

### 1st iteration:

| 1 | 3 | 5   | 6 |
|---|---| --- |---|
| l | m |     | r |


`target (7) > nums[m] (3) `

=> pick the right half

### 2nd iteration:

| 1 | 3 | 5 | 6 |
|---|---|---|---|
|   |   | l | r |


| 1 | 3 | 5     | 6 |
|---|---|-------|---|
|   |   | l = m | r |

`target (7) > nums[m] (5)`

=> pick the right half

### 3rd iteration:
| 1 | 3 | 5     | 6     |
|---|---|-------|-------|
|   |   |  | l = r |

target (7) > nums[m] (6)

### 4th iteration:

| 1 | 3 | 5     | 6     | |
|---|---|-------|-------|-|
|   |   |  |  r | l|

left > right, so we exit the loop.
return `l (4)` as the insertion index.

---

# Code
```python
class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums) - 1
        while l <= r:
            m = (l + r + 1) // 2
            if target > nums[m]:
                l = m + 1
            elif target < nums[m]:
                r = m - 1
            else:
                return m

        return l

```


# Time Complexity & Space Complexity
- TC: O(log n), in each iteration, we halve the array.

- SC: O(1), we use only a few variables for pointers.