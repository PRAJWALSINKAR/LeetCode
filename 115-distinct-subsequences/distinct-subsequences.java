class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int [][] dp = new int[m][n];
        for(int [] arr : dp){
            Arrays.fill(arr , -1);
        }
        return helper(0 , 0 , s , t, dp);
    }
    public int helper(int idx1 , int idx2 , String s , String t , int [][] dp){
        if(idx2 == t.length())return 1;

        if(idx1 == s.length())return 0;

        if(dp[idx1][idx2] != -1)return dp[idx1][idx2];

        int notTake = helper(idx1 +1 , idx2 , s , t, dp);
        int take =0;
        if(s.charAt(idx1) == t.charAt(idx2)){
            take = helper(idx1+1 , idx2 +1,s ,t, dp);
        }
        dp[idx1][idx2] = take + notTake;

        return dp[idx1][idx2];
    }
}