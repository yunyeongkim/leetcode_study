At first glance, merging two sorted arrays seemed like a straightforward problem requiring a simple loop and extra space to store the merged result. However, the challenge lay in performing this operation **in-place**, meaning no extra space should be used apart from the given arrays.

The additional constraint of "in-place" makes this problem more difficult, as it forces us to work within the memory constraints of `nums1` and `nums2`, preventing the use of auxiliary arrays.

---

### First Try

We can alleviate the in-place constraint by swapping the elements and saving spaces.

- Swapping elements between `nums1` and `nums2` is easy in simple cases.
  - However, if the swapped element is much larger (e.g., swapping `100` and `2`), it needs to be placed back in the correct position.
  - This can be achieved by shifting elements, but it introduces additional complexity.
- A binary search might help in placing elements correctly, but it still introduces additional overhead.
  - This additional complexity can be reduced by transforming the second array into a heap.

### Second Try: Avoiding Extra Space Complexity

- The naive approach using a heap (for fast insertions) fails since it requires **O(n log n)** time.

---

### **1. Using the Extra Space in `nums1` as a Temporary Buffer** (Failed)

Since `nums1` has enough space to hold both arrays, I realized I could use its extra space to temporarily store displaced elements.

Example:

```
nums1:  0  1  1  100 101 104 x  x  x  x  x  x  x
nums2:  2  2  2  2  2  103 105
```

When encountering a larger element (e.g., `100`), instead of swapping it directly, we can **push it to the right and use the remaining space as a queue**.

But this method failed to meet the requirements of the problem.

> Failed

## **My Thought Process and Struggles**

I initially tried many different approaches, including:

- Swapping elements between `nums1` and `nums2` when needed.
- Keeping a temporary buffer for displaced elements.
- Even considering turning `nums2` into a heap to ensure fast insertions.

But **no matter how I tried, I could not reach the answer.**

### **The Moment of Realization**

Eventually, I looked at the solution, and I was **shocked**.  
The trick was to **think in the opposite way**.

Instead of merging from the front and shifting elements, I realized:

- If I compare elements from the **back**, I can directly place the largest one in the empty spaces at the end of `nums1`.
- This ensures that **they never get overwritten**, making it the optimal approach.

---

### The Reverse Comparison Trick

A key realization was that since `nums1` has extra space at the end, we can **fill it from the back** instead of the front. This prevents the need to shift elements around.

Example:

- Start comparing from the end of `nums1` and `nums2`, placing the larger element at the end of `nums1`.

```
nums1:  0  1  1  100 101 104 x  x  x  x  x  x  x
nums2:  2  2  2  2  2  103 105
```

- Compare `104` and `105` → Place `105` at the last position.
- Compare `104` and `103` → Place `104` at the second last position.
- Continue until all elements are merged.

### **3. Why This Works in O(m + n)**

- We traverse both arrays once (O(n)).
- We fill elements from the back, avoiding unnecessary shifts.
- Since each element is placed exactly once, the time complexity remains **O(m + n)**.

---

## **Final Algorithm**

1. Use three pointers:
   - `i = m-1` (end of valid elements in `nums1`)
   - `j = n-1` (end of `nums2`)
   - `k = m + n - 1` (end of `nums1` including extra space)
2. Compare `nums1[i]` and `nums2[j]`, placing the larger element at `nums1[k]`.

3. Repeat until all elements are placed.

4. If any elements remain in `nums2`, place them at the beginning of `nums1`.

---

## **Final Code**

```go
func merge(nums1 []int, m int, nums2 []int, n int) {
    i, j, k := m-1, n-1, m+n-1

    for i >= 0 && j >= 0 {
        if nums1[i] > nums2[j] {
            nums1[k] = nums1[i]
            i--
        } else {
            nums1[k] = nums2[j]
            j--
        }
        k--
    }

    for j >= 0 {
        nums1[k] = nums2[j]
        k--
        j--
    }
}
```

written in go.
