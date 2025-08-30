class Solution {
    public int maxProfit(int[] arr, int fee) {
         int n = arr.length;
        int [][] dp = new int[n][2];
        for(int [] az : dp){
            Arrays.fill(az , -1);
        }
        return helper(0 , 0 ,fee, arr , dp);
    }
    public int helper(int ind , int buy , int fee ,int [] arr , int[][] dp){
        if(ind >= arr.length)return 0;

        if(dp[ind][buy] != -1)return dp[ind][buy];

        int profit =0;

        if(buy == 0){
            profit = Math.max(helper(ind+1 , 0 ,fee, arr , dp) , -arr[ind] + helper(ind +1 , 1 ,fee, arr, dp));
        }
        else{
            profit = Math.max(helper(ind+1 ,1 ,fee, arr,dp) , +arr[ind]-fee + helper(ind+1,0,fee, arr,dp));
        }
        return dp[ind][buy] =profit;
    }
}