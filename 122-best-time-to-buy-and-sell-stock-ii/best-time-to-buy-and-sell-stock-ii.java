class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2]; 
        // dp[n][0] = dp[n][1] = 0  (base case already default)

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 0) { // can buy
                    profit = Math.max(
                        -prices[ind] + dp[ind + 1][1], // buy
                        dp[ind + 1][0]                 // skip
                    );
                } else { // can sell
                    profit = Math.max(
                        prices[ind] + dp[ind + 1][0],  // sell
                        dp[ind + 1][1]                 // skip
                    );
                }
                dp[ind][buy] = profit;
            }
        }

        return dp[0][0]; // answer starting at day 0, in "can buy" state
    }
}
