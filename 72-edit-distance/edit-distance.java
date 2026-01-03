class Solution {
    public int minDistance(String word1, String word2) {
        int n =  word1.length();
        int m = word2.length();
        Integer [][] dp = new Integer[n][m];
        return helper(n-1 , m-1 , word1 , word2 , dp);
    }
    public int helper(int ind1 , int ind2 , String s1 , String s2 , Integer[][] dp){
        if(ind1 < 0)return ind2 +1;
        if(ind2 < 0)return ind1 + 1;

        if(dp[ind1][ind2] != null)return dp[ind1][ind2];

        if(s1.charAt(ind1) == s2.charAt(ind2))return helper(ind1-1 , ind2-1 , s1 , s2 , dp);

        int insert = 1 + helper(ind1 , ind2 -1 , s1 , s2 , dp);
        int delete = 1 + helper(ind1 - 1 , ind2 , s1 , s2 , dp);
        int replace = 1 + helper(ind1 - 1 , ind2 -1 , s1 , s2 , dp);

        return dp[ind1][ind2] = Math.min(insert , Math.min(delete , replace ));
    }
}