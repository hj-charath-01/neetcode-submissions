class Solution {
    public int maxSubArray(int[] nums) {
        return dfs (nums, 0, nums.length - 1);
    }

    private int dfs (int[] nums, int start, int end) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }

        int mid = (start + end) >> 1;

        int leftSum = 0, rightSum = 0, currSum = 0;
        for (int i = mid - 1; i >= start; i--) {
            currSum += nums[i];
            leftSum = Math.max (leftSum, currSum);
        }

        currSum = 0;
        for (int i = mid + 1; i <= end; i++) {
            currSum += nums[i];
            rightSum = Math.max (rightSum, currSum);
        }

        return Math.max (leftSum + rightSum + nums[mid], Math.max (dfs(nums, start, mid -1), dfs(nums, mid + 1, end)));
    }
}
