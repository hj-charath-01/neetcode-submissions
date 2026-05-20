class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int minCoins = dfs (amount, coins);
        return  minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private int dfs (int amount, int[] coins) {
        if (amount == 0) return 0;
        if (memo.containsKey (amount)) return memo.get(amount);

        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int res = dfs (amount - coin, coins);
                if (res != Integer.MAX_VALUE) {
                    result = Math.min (result, 1 + res);
                }
            }
        }

        memo.put (amount, result);
        return result;
    }
}
