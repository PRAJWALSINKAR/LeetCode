class Solution {
    public int numDistinct(String s, String t) {
        // Create a 2D array to store the counts of subsequences
        int prime = (int) (Math.pow(10, 9) + 7);
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n + 1][m + 1];

        // Initialize the first column with 1 because there's one empty subsequence in any string.
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        // Initialize the first row (except dp[0][0]) with 0 because there's no way to form s2 from an empty string.
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = 0;
        }

        // Fill the dp array using a bottom-up approach
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // If the characters match, we can either include this character in the subsequence
                    // or exclude it. So, we add the counts from both possibilities.
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) ;
                } else {
                    // If the characters don't match, we can only exclude this character.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
}