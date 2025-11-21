class Solution {
    private static final int MOD = 1000000007;

    public int numberOfWays(int n, int x) {
        Integer[][] dp = new Integer[n + 1][n + 1];
        return helper(n, n, x, dp);
    }

    private int helper(int start, int target, int pow, Integer[][] dp) {

        if (target < 0) return 0;
        if (target == 0) return 1;

        if (dp[start][target] != null) return dp[start][target];

        int res = 0;

        for (int i = start; i >= 1; i--) {
            long val = (long) Math.pow(i, pow);
            if (val <= target) {
                res = (res + helper(i - 1, target - (int) val, pow, dp)) % MOD;
            }
        }

        return dp[start][target] = res;
    }
}
