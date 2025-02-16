class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
           int [][] dp = new int[m][n];
          for(int [] row  : dp){
             Arrays.fill(row, -1);
            }
        return f(m-1 , n-1 , dp , obstacleGrid);
    }
    public static int f(int row , int col ,  int [][] dp, int [][] arr){
        if(arr[row][col] == 1) return 0;
       if(row == 0 && col == 0){
        return 1;
       }
       if(dp[row][col] != -1) return dp[row][col];
           
        int left = 0;
        int up = 0;
        if(row > 0){
        left = f(row-1 , col , dp , arr);
        }
        if(col > 0){
        up = f(row , col-1 , dp , arr);
         }
       return dp[row][col] = left + up;  
        }
}