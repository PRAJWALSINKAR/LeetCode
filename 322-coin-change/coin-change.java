class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer [][] dp = new Integer[coins.length][amount+1];
        int ans = helper(0 , coins , amount , dp);
        if(ans >= Integer.MAX_VALUE - 5000)return -1;
        return ans;
    }
    public int helper(int ind , int [] arr , int amount , Integer[][] dp ){
        if(amount == 0)return 0;
        if(ind == arr.length)return Integer.MAX_VALUE - 5000;

        if(dp[ind][amount] != null)return dp[ind][amount];

        int take = Integer.MAX_VALUE;
        if(amount - arr[ind] >= 0){
            take = 1 + helper(ind , arr , amount - arr[ind] , dp);
        }
        int nontake = helper(ind + 1 , arr , amount , dp);

        return dp[ind][amount] = Math.min(take , nontake);
    }
}