class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
    int m = arr.length;
    int n = arr[0].length;
    int [][] dp = new int[m][n]; 
    if(arr[m-1][n-1] == 1)return 0;
    return helper(0 , 0 , dp , arr);
   }
   public static int helper(int row , int col , int[][] dp, int [][] arr){//0 0 
   
    if(row >= arr.length  || col >= arr[0].length)return 0;
    if(arr[row][col] == 1)return 0;

    if(row == arr.length -1 && col == arr[0].length-1)return 1;


    if(dp[row][col] != 0)return dp[row][col];

    int right = helper(row ,col+1, dp , arr); //0 1  return 1
    int down = helper(row+1 , col , dp , arr); //1 0 

    dp[row][col] = right + down;
    return dp[row][col];
   }
}