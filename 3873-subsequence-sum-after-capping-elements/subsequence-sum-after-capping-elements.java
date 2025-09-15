class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        boolean[] ans = new boolean[n];

        // counts of values (1..n)
        int[] cnt = new int[n + 1];
        for (int v : nums) cnt[v]++;

        // dp[s] = reachable sum s using elements with value < current x
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;

        int prefixLess = 0; // number of elements with value < x
        for (int x = 1; x <= n; x++) {
            // number of elements >= x (these become value x after capping)
            int totGe = n - prefixLess;
            int maxT = Math.min(totGe, k / x);

            boolean possible = false;
            for (int t = 0; t <= maxT; t++) {
                int need = k - t * x;
                if (need < 0) break;
                if (dp[need]) { possible = true; break; }
            }
            ans[x - 1] = possible;

            // incorporate all elements equal to x into dp for next x
            int c = cnt[x];
            for (int rep = 0; rep < c; rep++) {
                for (int s = k; s >= x; s--) {
                    if (dp[s - x]) dp[s] = true;
                }
            }
            prefixLess += c;
        }

        return ans;
    }
}
