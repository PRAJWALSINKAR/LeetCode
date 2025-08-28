class Solution {
    public int minInsertions(String s) {
        int  n = s.length();
        int dp[][] = new int[n+1][n+1];
       String s2 = new StringBuilder(s).reverse().toString();
       int LongL = helper(s , s2 , dp);
       return n-LongL;
    }

    public static int helper(String s1 , String s2 , int[][] dp){
        int n = s1.length();

        for(int i = 1 ; i <= n ; i++ ){
            for(int j =1 ; j<= n ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}