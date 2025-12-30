class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        Integer [] dp = new Integer[n];
        int first = helper(0 , n-1 , nums , dp);
        dp = new Integer[n];
        int sec = helper(1 , n , nums , dp);

        return Math.max(first , sec);
    }

    public int helper(int ind , int end , int [] nums , Integer [] dp){
        if(ind >= end)return 0;

        if(dp[ind] != null)return dp[ind];

        int take = nums[ind] + helper(ind+2 , end , nums , dp);

        int notTake =  helper(ind +1 , end , nums , dp);
        
        return dp[ind] = Math.max(take , notTake);

    }
}