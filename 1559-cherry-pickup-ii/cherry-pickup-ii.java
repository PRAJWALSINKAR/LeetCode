class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Integer [][][] dp = new Integer[n][m][m];
        return helper(0 , 0 , m-1,  grid , dp);
    }
    public int helper(int row , int col1 , int col2 , int [][]grid, Integer[][][] dp ){
        if(row == grid.length)return 0;

        if(col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length)return 0;
        
        if(dp[row][col1][col2] != null)return dp[row][col1][col2];
        int ans = 0;
        if(col1 == col2){
            ans += grid[row][col1]; 
        }else{
            ans += (grid[row][col1] + grid[row][col2]);
        }
        int max = Integer.MIN_VALUE;
      
        for(int i = -1 ; i < 2 ; i++){
            for(int j =-1 ; j <2 ; j++){
            
                max = Math.max(max , helper(row+1 , col1 + i , col2 + j , grid , dp));
            }
        }
        return dp[row][col1][col2] =max+ans;
    }
}