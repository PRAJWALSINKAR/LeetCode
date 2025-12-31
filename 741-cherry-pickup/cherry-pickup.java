class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer [][][][] dp = new Integer[n][n][n][n];
        int ans = helper(0 , 0 , 0 ,0 , grid , dp );
        if(ans ==Integer.MIN_VALUE)return 0;
        return ans;
    }
    public int helper(int row1 , int col1 , int row2 , int col2 , int [][] grid , Integer[][][][] dp){
        int n = grid.length;

        if(row1 == n-1 && row2 == n-1 && col1 == n-1 && col2 == n-1){
            if(grid[row1][col1] == -1)return Integer.MIN_VALUE;
            if(grid[row1][col1] == 0)return 0;
            if(grid[row1][col1] == 1)return 1; 
        }
        if(row1 >= n || row2 >= n || col1 >= n || col2 >= n || grid[row1][col1] == -1 || grid[row2][col2] == -1)return Integer.MIN_VALUE;
        if(dp[row1][col1][row2][col2] != null)return dp[row1][col1][row2][col2];
        int candy = 0;
        if(row1 == row2 && col1 ==col2){
            candy = grid[row1][col1];
        }else{
            candy = (grid[row1][col1]+ grid[row2][col2]);
        }
        int max = Integer.MIN_VALUE; 
        
        int downDown = helper(row1+1 ,col1 , row2+1,  col2 , grid , dp);

        int downRight = helper(row1+1 ,col1 , row2 , col2+1 , grid , dp);

        int rightDown = helper(row1 ,col1 +1 , row2+1 , col2 , grid, dp);

        int rightRight = helper(row1 ,col1+1 , row2 , col2+1 , grid , dp);

        int first  = Math.max(downDown , downRight);
        int sec  = Math.max(rightRight , rightDown);

        max = Math.max(first , sec);
        if(max == Integer.MIN_VALUE)return dp[row1][col1][row2][col2] = max;
        return dp[row1][col1][row2][col2] =max + candy;

    }
}