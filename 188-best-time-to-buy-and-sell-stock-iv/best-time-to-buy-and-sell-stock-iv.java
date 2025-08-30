class Solution {
    public int maxProfit(int k, int[] arr) {
        int n = arr.length;
        int dp[][][] = new int[n][2][k*2];
        for(int zp[][] : dp){
            for(int[] i : zp){
                Arrays.fill(i , -1);
            }
        }
        return helper(0, 0 , 0 , k*2 , arr , dp);
    }
    public static int helper(int ind , int buy , int trans , int target , int [] arr , int [][][]dp){
        if(ind >= arr.length || trans >= target)return 0;

        if(dp[ind][buy][trans] != -1)return dp[ind][buy][trans];

        int profit = 0;

        if(buy == 0){
            profit = Math.max(helper(ind+1 , 0 , trans ,target, arr, dp), -arr[ind]+helper(ind+1 , 1,trans+1,target, arr, dp ));
        }else{
            profit = Math.max(helper(ind+1 , 1 , trans,target, arr,dp), arr[ind] + helper(ind+1,0 ,trans+1 ,target ,arr, dp));
        }
        return dp[ind][buy][trans] = profit;
    }
}