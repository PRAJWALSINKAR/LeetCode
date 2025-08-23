class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][]dp = new int[m][n];
        for(int [] arr : dp){
            Arrays.fill(arr , Integer.MAX_VALUE);
        } 
        for(int i =0 ; i<1;i++){
            for(int j =0 ;j<n ;j++){
                int val = helper(i , j , matrix , dp);
                ans= Math.min(ans , val);
            }
        }
        return ans;
    }
    public static int helper(int i , int j , int[][]arr , int [][] dp){
        if(i < 0 || j <0 || i>= arr.length || j >= arr[0].length)return Integer.MAX_VALUE;

        if(i == arr.length-1)return arr[i][j];

        if(dp[i][j] != Integer.MAX_VALUE)return dp[i][j];

        int down = helper(i+1 , j , arr , dp);
        int downLeft = helper(i+1 , j-1 , arr , dp);
        int downRight = helper(i+1 , j+1 , arr , dp);

        dp[i][j] = arr[i][j] + Math.min(down , Math.min(downLeft ,downRight ));
        return dp[i][j];
    }
}