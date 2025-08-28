class Solution {
    public int minInsertions(String s) {
        int  n = s.length();
        int dp[][] = new int[n][n];
        for(int ar [] : dp){
            Arrays.fill(ar , -1);
        }
        int longP = helper(0 , n-1 , s , dp);
        return n - longP;
    }

    public static int helper(int ind1 , int ind2 , String s , int [][]dp){
        if(ind1 == ind2)return 1;
        if(ind1 > ind2)return 0;

        if(dp[ind1][ind2] != -1)return dp[ind1][ind2];

        if(s.charAt(ind1) == s.charAt(ind2)){
            return dp[ind1][ind2] = 2+ helper(ind1 +1 ,ind2-1 , s , dp);
        }
        return dp[ind1][ind2] = Math.max(helper(ind1 +1 , ind2 , s , dp) ,helper(ind1 , ind2 -1, s , dp));
    }
}