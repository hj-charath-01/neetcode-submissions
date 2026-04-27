class Solution {
    public int maxProfit(int[] prices) {
        
        int buy = 0, sell = 1;
        int maxPr = 0;

        while (sell < prices.length) {
            if (prices[buy] < prices[sell]) {
                maxPr = Math.max (prices[sell] - prices[buy], maxPr);
            } else {
                buy = sell;
            }

            sell++;
        }

        return maxPr;
    }
}
