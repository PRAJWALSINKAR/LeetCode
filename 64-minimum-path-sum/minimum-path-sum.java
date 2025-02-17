class Solution {
    public int minPathSum(int[][] grid) {
        int m  = grid.length;
        int n = grid[0].length;

        int [][] dp = new int[m][n];
        for(int i=0 ; i< m ; i++){
            Arrays.fill(dp[i] , -1);
        }
        return f(m-1 , n-1 , dp , grid);
    }
    public static int f(int row , int col , int [][] dp , int [][] arr){
        if(row == 0 && col == 0 ){
            return arr[0][0];
        }
        if(dp[row][col] != -1) return dp[row][col];
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if(col > 0){
            left = f(row , col-1 , dp , arr);
        }
         if(row > 0){
            up = f(row-1 , col , dp , arr);
        }
        return dp[row][col] = arr[row][col] + Math.min(left , up) ;
    }
}