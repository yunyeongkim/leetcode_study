class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = binarySearchLeft(nums, target);
        result[1] = binarySearchRight(nums, target);
        return result;
    }

    private int binarySearchLeft(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                result = mid;
                right = mid - 1; // 더 왼쪽에 있는 target을 찾기 위해
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private int binarySearchRight(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                result = mid;
                left = mid + 1; // 더 오른쪽에 있는 target을 찾기 위해
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}