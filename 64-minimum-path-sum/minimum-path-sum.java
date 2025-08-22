class Solution {
    public int minPathSum(int[][] grid) {
        int m =grid.length;
        int n = grid[0].length;
        int [][] dp =new int[m][n];
        for(int [] arr : dp){
        Arrays.fill(arr , Integer.MAX_VALUE);
        }
        return helper(0 , 0 , grid , dp);
    }
    public static int helper(int row , int col , int [][] grid , int [][] dp){
        if(row< 0 || col < 0 || row >= grid.length || col >= grid[0].length)return Integer.MAX_VALUE;
        
        if(row == grid.length-1 &&  col == grid[0].length-1)return grid[row][col];

        if( dp[row][col] != Integer.MAX_VALUE)return dp[row][col];

        int right = helper(row , col+1 , grid , dp);  
        int down =  helper(row+1 , col , grid , dp);

        dp[row][col] = grid[row][col] + Math.min(right , down);

        return dp[row][col];
    }
}