class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        Integer [][][] dp = new Integer[grid.length][grid[0].length][k+1];
        return helper(0 , 0, grid[0][0] , grid , k , dp);
    }
    public int helper(int row , int col ,int sum ,  int [][] grid , int k , Integer [][][] dp ){
        int n = grid.length;
        int m  = grid[0].length;

        if(row == n-1 && col == m-1){
            if(sum % k == 0)return 1;
            return 0;
        }

      if(dp[row][col][sum%k] != null )return dp[row][col][sum % k]; 
        int right = 0;
        int down = 0;
        if(col+1 < m)
        right = helper(row , col+1 , (sum + grid[row][col+1])%k , grid , k , dp);
        
        if(row+1 < n)
        down = helper(row  + 1 , col , (sum + grid[row+1][col])%k, grid , k , dp);
        long ans = (long)right + (long)down ;
        return dp[row][col][sum % k] = (int)ans % 1000000007 ;
    }
}