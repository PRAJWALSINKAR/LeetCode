class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int [][] dp = new int[n][amount +1];
        for(int[] i : dp){
            Arrays.fill(i  , -1);
        }
        int ans = helper(n-1 , amount , coins , dp);
        if(ans == Integer.MAX_VALUE-500)return -1;
        return ans;
    }
    public static int helper(int ind , int target , int [] nums , int [][] dp){
        if(ind == 0){
            if(target % nums[ind]== 0)return target/nums[ind];
            return Integer.MAX_VALUE-500;
        }

        if(dp[ind][target] != -1)return dp[ind][target];

        int nonTake = 0 + helper(ind -1, target , nums , dp);
        int take = Integer.MAX_VALUE;
        if(nums[ind] <= target){
            take = Math.min(take , 1 + helper(ind ,target -  nums[ind] , nums , dp ));
        }
        dp[ind][target] = Math.min(take , nonTake);
        return dp[ind][target];
    }
}