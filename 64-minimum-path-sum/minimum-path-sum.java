class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0 ; i< m ;i++ ){  // travel a row
            for(int j = 0 ; j< n ;j++){ // tavel a col
              if(i==0 && j ==0){
                dp[i][j] = grid[i][j];
                continue;
              }
              int right = 0;
              int down = 0;
              if(i == 0 && j < n ){
             dp[i][j] = dp[i][j-1] + grid[i][j];
             continue;
              }
              if(j==0 && i < m){
                dp[i][j] = dp[i-1][j] + grid[i][j];
                continue;
              }
              right = dp[i-1][j] + grid[i][j];
              down = dp[i][j-1] + grid[i][j];
              dp[i][j] = Math.min(right , down);
            }
        }
      return dp[m-1][n-1];
     }
}