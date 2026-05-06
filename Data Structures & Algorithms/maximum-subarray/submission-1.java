class Solution {
    public int maxSubArray(int[] nums) {
        return dfs (nums, 0, nums.length - 1);
    }

    private int dfs (int[] nums, int left, int right) {
        if (left > right) {
            return Integer.MIN_VALUE;
        }

        int mid = (left + right) >> 1;
        
        int leftSum = 0, currSum = 0, rightSum = 0;
        for (int i = mid - 1; i >= left; i--) {
            currSum += nums[i];
            leftSum = Math.max (leftSum, currSum);
        }

        currSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            currSum += nums[i];
            rightSum = Math.max (rightSum, currSum);
        }

        return Math.max (dfs (nums, left, mid - 1), Math.max (dfs (nums, mid + 1, right), leftSum + nums[mid] + rightSum));
    }
}
