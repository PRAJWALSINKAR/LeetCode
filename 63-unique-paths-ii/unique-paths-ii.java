class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length; 
           int [][] dp = new int[m][n];
            
           for(int i = 0 ; i< m ; i++){
              for(int j = 0 ;j< n;j++){
                 if(obstacleGrid[i][j] == 1 ){
                 dp[i][j] = 0;
                 continue;
                }
                 if(i==0 && j==0){
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0;
                int down = 0; 
              if( j >0){
             up = dp[i][j-1] ;
              }
              if(i > 0){
             down = dp[i-1][j];
              }
              dp[i][j]= up + down;
            }
           }
           return dp[m-1][n-1];
    }
}
  