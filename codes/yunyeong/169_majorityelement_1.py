# Boyer-Moore Voting Algorithm
class Solution(object):
    def majorityElement(self, nums):
        count=0
        number=None
        for num in nums:
            if count==0:
                number=num
            if num==number:
                count+=1
            else:
                count-=1
        return number
# O(n) /  O(1) space complexticy