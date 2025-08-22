class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int arr[] : dp){
            Arrays.fill(arr , -1);
        }
        return helper(0 , 0 ,dp ); 
    }

    public static int helper(int row, int col , int [][] dp){

        if(row == dp.length-1 || col == dp[0].length-1)return 1;

        if(dp[row][col] != -1)return dp[row][col];

        int right = helper(row , col +1,dp);
        int down = helper(row +1 , col , dp);

        dp[row][col] = right + down; 
        return dp[row][col];      
    }
}