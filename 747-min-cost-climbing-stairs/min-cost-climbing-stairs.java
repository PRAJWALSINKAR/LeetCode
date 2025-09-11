class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int []  dp = new int[n];
        Arrays.fill(dp , -1);
        return Math.min(helper(0, dp , cost) , helper(1 ,dp, cost));
    }
    public int helper(int ind , int [] dp , int[] cost){
        if(ind >= cost.length)return 0;
        if(dp[ind] != -1)return dp[ind];
        
        int oneStep = cost[ind] + helper(ind +1 , dp , cost);

        int twoStep = cost[ind] + helper(ind+2 , dp , cost);

        return dp[ind]=Math.min(oneStep  , twoStep);
    }
}