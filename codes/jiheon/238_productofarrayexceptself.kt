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