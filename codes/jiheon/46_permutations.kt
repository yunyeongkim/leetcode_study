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