class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
          for(int [] row  : dp){
             Arrays.fill(row, -1);
            }
        return f(m-1 , n-1 , dp);
    }
    public static int f(int row , int col ,  int [][] dp){
       if(row == 0 || col == 0){
        return 1;
       }
       if(dp[row][col] != -1) return dp[row][col];
           
        int left = 0;
        int up = 0;
        if(col > 0){
        left = f(row-1 , col , dp);
        }
        if(row > 0){
        up = f(row , col-1 , dp );
         }
       return dp[row][col] = left + up;  
        }
}