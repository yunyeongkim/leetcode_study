[problem](https://leetcode.com/problems/product-of-array-except-self/)

## IDEA
- This problem can be solved in two ways — by using division, or by avoiding it entirely.


## Solution

### With divide

-  Multiple zeros in the array will make `mul` end up as zero. => early return
- If there is exactly one zero, all elements in the result will be zero except at the index of the zero, which will hold the product of all non-zero elements.
- If there is no zero, we compute result by dividing `mul` by `nums[i]` for each index.
```java
 public int[] productExceptSelf(int[] nums) {

		int zeroIdx = -1, mul=1;
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroIdx != -1) {
                    return ans;
                } else {
                    zeroIdx = i;
                }
            } else {
                mul *= nums[i];
            }
        }
       
        if (zeroIdx == -1) {
            for (int i = 0; i < nums.length; i++) {
                ans[i] = mul / nums[i];
            }
        } else {
            ans[zeroIdx] = mul;
        }
        return ans;
    }
    
```



### Without divide (use prefix)

- The result value of `index[i]` is the product of all elements before and after `index[i]`.
- We can use prefix product to efficiently calculate the product of elements to the left and right of each index.

```kotlin
fun productExceptSelf(nums: IntArray): IntArray {  
    val ans = IntArray(nums.size){1};  
    
    for (i in 1 until nums.size){  
        ans[i] = ans[i-1]*nums[i-1];  
    }  
  
    var tmp = 1;  
    for (i in nums.size-1 downTo 0){  
        ans[i] *=tmp;  
        tmp*=nums[i]  
    }  
  
    return ans;  
}
```



