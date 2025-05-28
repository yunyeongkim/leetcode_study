[problem](https://leetcode.com/problems/climbing-stairs/description/)

## IDEA
- It's a simple DP problem.

## Code/Solution

```java
class Solution {

    public int climbStairs(int n) {

        if (n <= 2) return n;
        
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        
        for(int i=2; i<n;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[arr.length-1];
    }

}
```