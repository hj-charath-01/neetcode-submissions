class Solution {
    private int[] dp;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill (dp, -1);

        int maxLIS = 1;
        for (int i = 0; i < n; i++) {
            maxLIS = Math.max (maxLIS, dfs (nums, i));
        }

        return maxLIS;
    }

    private int dfs (int[] nums, int i) {
        if (dp[i] != -1) {
            return dp[i];
        }

        int LIS = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] < nums[j]) {
                LIS = Math.max (LIS, 1 + dfs (nums, j));
            }
        }

        dp[i] = LIS;
        return LIS;
    }
}
