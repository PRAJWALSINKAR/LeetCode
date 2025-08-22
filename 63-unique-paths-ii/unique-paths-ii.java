class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int [][] dp = new int[m][n];
        if(arr[0][0] == 1)return 0;
        boolean visJ = false;
        for(int i = 0 ;  i < m;i++){
            for(int j= 0;j< n ; j++){
                if(j == 0 && arr[i][j] ==1){
                    visJ = true;
                    continue;
                }
                 
                if(visJ && j==0)continue;
                
                if(i == 0 && arr[i][j] == 1)break;//if obstacle found in 1st row then all other roe elecment 0
                
                if(arr[i][j] == 1){  
                    dp[i][j] =0;
                    continue;
                }
                
                if(i== 0 || j== 0){
                    dp[i][j] = 1;
                    continue;
                
                }
                dp[i][j] = dp[i-1][j] +  dp[i][j-1] ;
            }
        }
        return dp[m-1][n-1];
    }
}