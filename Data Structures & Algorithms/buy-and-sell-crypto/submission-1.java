class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxRight = prices[n - 1];

        int max = 0;
        for (int i = n - 2; i >= 0; i--) {
            int curr = maxRight - prices[i];
            max = Math.max (max, curr);

            maxRight = Math.max (maxRight, prices[i]);
        }

        return max;
    }
}
