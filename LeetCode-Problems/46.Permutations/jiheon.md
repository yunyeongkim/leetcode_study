[problem](https://leetcode.com/problems/permutations/)

## IDEA
 *There are two ways to solve this problem.*
	1. Use a stack to build the permutation step by step
	2. Swap elements in Original array to generate permutations in-place

Both methods use DFS and backtracking to find all possible permutations.



## Solution

- Use the stack
```java
class Solution {  
    public List<List<Integer>> permute(int[] nums) {  
        List<List<Integer>> answer = new ArrayList<>();  
  
        dfs(answer, new ArrayList<>(), nums, new boolean[nums.length]);  
        return answer;  
    }  
  
    private void dfs(List<List<Integer>> answer, List<Integer> cur, int[] nums, boolean[] used) {  
  
        if (cur.size() == nums.length) {  
            answer.add(new ArrayList<>(cur));  
            return;  
        }  
  
        for (int i = 0; i < nums.length; i++) {  
            if (used[i]) continue;  
            cur.add(nums[i]);  
            used[i] = true;  
            dfs(answer, cur, nums, used);  
            cur.remove(cur.size() - 1);  
            used[i] = false;  
        }  
    }  
}
```


- Swap original Array
```kotlin
class Solution1 {  
    fun permute(nums: IntArray): List<List<Int>> {  
        val ans = ArrayList<List<Int>>();  
  
        fun dfs(idx: Int) {  
            if (idx == nums.size - 1) {  
                ans.add(nums.toList())  
                return  
            }  
            for (i in idx..<nums.size) {  
                nums[idx] = nums[i].also { nums[i] = nums[idx] }  
                dfs(idx + 1)  
                nums[idx] = nums[i].also { nums[i] = nums[idx] }  
            }  
        }  
        dfs(0)  
        return ans  
    }  
}
```