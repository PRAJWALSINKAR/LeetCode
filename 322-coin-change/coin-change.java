import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = Integer.MAX_VALUE - 500;
        
        int[][] dp = new int[n][amount + 1];

        // Base case (using only the first coin)
        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) {
                dp[0][t] = t / coins[0];
            } else {
                dp[0][t] = INF;
            }
        }

        // Fill the table
        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= amount; t++) {
                int nonTake = dp[i - 1][t];
                int take = INF;
                if (coins[i] <= t) {
                    take = 1 + dp[i][t - coins[i]];
                }
                dp[i][t] = Math.min(take, nonTake);
            }
        }

        int ans = dp[n - 1][amount];
        return (ans >= INF) ? -1 : ans;
    }
}
