class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [][] dp = new int[n][n+1];
        for(int [] ar : dp){
            Arrays.fill(ar , -1);
        }
        return helper(0 , -1 , dp , nums);
    }
    public static int helper(int ind , int prev , int [][]dp , int [] arr){
        if(ind == arr.length)return 0;

        if(dp[ind][prev+1] != -1)return dp[ind][prev+1];

        int notTake = helper(ind+1 , prev , dp , arr);
        int take = 0;
        if(prev ==-1 || arr[ind] > arr[prev]){
            take = 1 + helper(ind+1 , ind , dp , arr);
        }

        int len = Math.max(take , notTake);

        return dp[ind][prev+1] = len;
    }
}