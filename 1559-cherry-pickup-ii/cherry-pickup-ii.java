class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][][] dp= new int[n][m][m];
        for(int [][] arr : dp){
            for(int [] zp : arr){
                Arrays.fill(zp , Integer.MIN_VALUE);
            }
        }
        return helper(0,0,m-1,n , m , grid , dp);
    }

    public int helper(int row , int col1,int col2 , int rowl, int coll,int [][]arr , int[][][]dp){
        if(row <0 || col1<0 || col2<0 || row >= rowl || col1 >=coll || col2 >= coll)return Integer.MIN_VALUE;

        if(row == rowl - 1){
            if(col1 == col2){
                return arr[row][col1];
            }else{
                return arr[row][col1] + arr[row][col2];
            }
        }
        if(dp[row][col1][col2] != Integer.MIN_VALUE)return dp[row][col1][col2];

        int max = Integer.MIN_VALUE;

        for(int i =-1 ; i<2;i++){
            for(int j = -1 ;j <2 ; j++){
                if(col1 == col2){
                max = Math.max(max ,arr[row][col1] + helper(row+1,col1 + i,col2+j,rowl,coll,arr,dp));
                }else{
                max =Math.max(max, arr[row][col1] +arr[row][col2] + helper(row+1,col1 + i,col2+j,rowl,coll,arr,dp));
                }
            }
        }
        dp[row][col1][col2] = max;
        return max;
    }
}