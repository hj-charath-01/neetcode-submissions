class Solution {
    public int maxProfit(int[] prices) {
        int sell = prices.length - 1;
        int max = 0;

        for (int i = prices.length - 2; i >= 0; i--) {
            if(prices[i] < prices[sell]) {
                max = Math.max(max, prices[sell] - prices[i]);
            } else {
                sell = i;
            }
        }

        return max;
    }
}
