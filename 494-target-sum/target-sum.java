import java.util.*;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for (int x : nums) total += x;

        // if target is outside possible range
        if (target > total || target < -total) return 0;

        int offset = total;
        int[][] dp = new int[n + 1][2 * total + 1];

        // Base case: with 0 elements, only sum=0 is possible (shifted by offset)
        dp[0][offset] = 1;

        // Fill table
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int s = 0; s <= 2 * total; s++) {
                if (dp[i - 1][s] != 0) {
                    // add '+num'
                    if (s + num <= 2 * total) {
                        dp[i][s + num] += dp[i - 1][s];
                    }
                    // add '-num'
                    if (s - num >= 0) {
                        dp[i][s - num] += dp[i - 1][s];
                    }
                }
            }
        }

        return dp[n][target + offset];
    }
}
