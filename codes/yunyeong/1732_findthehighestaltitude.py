class Solution(object):
    def largestAltitude(self, gain):
        max = 0
        num = 0
        for i in range(len(gain)):
            num += gain[i]
            if max < num:
                max = num
        return max

# time O(n) / space O(1)