class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int row = 0; row <= m; row++) {
            dp[row][0] = row;
        }
        for (int col = 0; col <= n; col++) {
            dp[0][col] = col;
        }

        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                int cost = word1.charAt(row - 1) == word2.charAt(col - 1) ? 0 : 1;

                dp[row][col] = Math.min (dp[row - 1][col - 1] + cost, 1 + Math.min (dp[row - 1][col], dp[row][col - 1]));
            }
        }

        return dp[m][n];
    }
}
