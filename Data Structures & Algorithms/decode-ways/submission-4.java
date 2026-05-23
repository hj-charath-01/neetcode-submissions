class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return decode (0, s, dp);
    }

    private int decode (int i, String s, int[] dp) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (dp[i] != -1) return dp[i];

        int res = decode (i + 1, s, dp);
        if (i + 1 < s.length()) {
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (num >= 10 && num <= 26) {
                res += decode (i + 2, s, dp);
            }
        }

        return dp[i] = res;
    }
}
