class Solution:
    def maxSubArray(self, nums: list[int]) -> int:

        def __sub_function(i , current_sum, max_sum):
            if i == len(nums):
                return max_sum
            
            current_sum += nums[i]
            max_sum= max(max_sum, current_sum)
            print(f"i= {i} ,current ={current_sum} , max ={max_sum}")

            if current_sum < 0 :
                current_sum = 0
            return __sub_function(i+1,current_sum,max_sum)
        
        return __sub_function(0,0,nums[0])
# Output Limit Exceeded.