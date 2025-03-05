class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int [][] dp = new int[m][m];

        for(int i = 0 ; i< m ; i++){
            for(int j = 0 ; j< m ; j++){
                if(i == 0){
                    dp[i][j] = matrix[i][j];
                    continue;
                }
            int left = Integer.MAX_VALUE;
            int middle = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
                if(j>0){
                     left = dp[i-1][j-1] + matrix[i][j];
                }
                if(j<m-1){
                    right = dp[i-1][j+1] + matrix[i][j];
                }
                middle = dp[i-1][j] + matrix[i][j];

            int min1 = Math.min(left , right);
            int min2 = Math.min(min1 , middle); 


            dp[i][j] = min2;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i< m ; i++){
           if(min > dp[m-1][i]){
            min = dp[m-1][i];
           }
        }
        return min;
    }
}