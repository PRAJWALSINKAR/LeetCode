class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int[n][2];
        for(int arr[] : dp){
            Arrays.fill(arr , -1);
        }
        return helper(0 , 0 , prices , dp  );
    }
    public int helper(int ind , int buy , int[] arr , int[][] dp ){
        if(ind == arr.length )return 0;

        if(dp[ind][buy] != -1)return dp[ind][buy];

        int profit = 0;

        if(buy==0){
            profit = Math.max(- arr[ind] + helper(ind +1,1,arr,dp ),helper(ind+1,0,arr,dp));//Maath.max(byu , skip)
        }else{
            profit=Math.max(arr[ind] + helper(ind +1,0,arr,dp) , helper(ind+1 , 1,arr,dp));
        }
        return dp[ind][buy] = profit;
    }
}