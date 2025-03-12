class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int[n][amount+1];
        for(int i =0 ; i< n ; i++){
            Arrays.fill(dp[i] , -1);
        }
        int result= helper(n-1 , amount , coins , dp);
        if (result == Integer.MAX_VALUE - 1) {
        return -1;
        }
        return result;
    }
    public int helper(int ind , int target , int[] nums , int [][] dp){
        if (target == 0) return 0;
        
        if(ind == 0){
          if(target % nums[ind] ==0){
            return target / nums[ind];
          }else{
            return Integer.MAX_VALUE-1;
          }
        }
        if(dp[ind][target] != -1)return dp[ind][target];

        int nonTake = helper(ind - 1 , target , nums , dp);
        int take = Integer.MAX_VALUE-1;
        if(target >= nums[ind]){
            take = 1 + helper(ind  , target - nums[ind] , nums , dp); 
        }
        return dp[ind][target] = Math.min(take , nonTake);
    }
}