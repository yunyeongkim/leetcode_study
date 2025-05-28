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