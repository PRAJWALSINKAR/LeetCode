class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer [][] dp = new Integer[n][n+1];
        return helper(0 ,-1 , nums , dp);
    }

    public int helper(int ind , int prev ,int [] arr , Integer[][] dp){
        if(ind == arr.length)return 0;
        if(dp[ind][prev+1] != null)return dp[ind][prev+1];
        int take = 0;
        if( prev == -1 || arr[prev] < arr[ind]){
            take = 1 + helper(ind +1 , ind, arr , dp);
        }
        int nottake = helper(ind+1 , prev, arr , dp);

        return dp[ind][prev+1] = Math.max(take , nottake);
    }
}