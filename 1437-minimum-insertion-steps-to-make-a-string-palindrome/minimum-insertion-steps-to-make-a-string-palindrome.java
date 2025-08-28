class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int prev = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j)) { // no need for insertion
                    dp[j] = prev;
                } else {
                    dp[j] = Math.min(dp[j], dp[j-1]) + 1; // we nwwd +1 to add one element
                }
                prev = temp;
            }
        }
        return dp[n-1];
    }
} 