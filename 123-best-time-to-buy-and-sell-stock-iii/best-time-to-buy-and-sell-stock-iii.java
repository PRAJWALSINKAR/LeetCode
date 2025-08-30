class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int [][][] dp = new int[n][2][4];
        for(int [][] zp : dp){
            for(int dz[] : zp){
            Arrays.fill(dz , -1);
            }
        }
        return helper(0 , 0  , 0 , arr , dp);
    }
    public static int helper(int ind , int buy , int trans , int[] arr , int[][][] dp){
        if(ind >=arr.length || trans >= 4)return 0;
        
        if(dp[ind][buy][trans] != -1)return dp[ind][buy][trans];
        int profit = 0 ;

        if(buy == 0){
            profit = Math.max(helper(ind+1,0 ,trans,arr,dp) ,-arr[ind] +helper(ind+1,1,trans+1,arr,dp));
        }else{
            profit =Math.max(helper(ind+1,1,trans , arr,dp) , +arr[ind]+helper(ind+1,0,trans+1,arr,dp));
        }
        return dp[ind][buy][trans] = profit;
    }
}