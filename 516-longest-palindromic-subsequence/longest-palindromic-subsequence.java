class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n == 1)return 1;
        int[][] dp = new int[n][n];
        for(int [] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(0 , n-1 , s , dp); 
    }
    public static int helper(int ind1 , int ind2 ,String s , int[][] dp){
     if (ind1 > ind2) return 0;
     if (ind1 == ind2) return 1;

        if(dp[ind1][ind2] != -1)return dp[ind1][ind2];
        if(s.charAt(ind1) == s.charAt(ind2)){
            return dp[ind1][ind2] =2+ helper(ind1 + 1 , ind2-1 , s , dp);
        }
        return dp[ind1][ind2] =Math.max(helper(ind1 + 1 , ind2 , s , dp),helper(ind1 , ind2 -1, s , dp) );
    }
}