class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1 )return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1 , -1);
        Arrays.fill(dp2 , -1);
        return Math.max(helper(n-1 , 1 , nums,dp1),helper(n-2 , 0 , nums,dp2));
    }
  public int helper(int n , int start , int [] nums , int [] dp){
    if(n < start)return 0;

    if(dp[n] != -1)return dp[n];

    int take = helper(n-2 , start , nums , dp) + nums[n];

    int nonTake = helper(n-1 , start , nums , dp);

    dp[n] = Math.max(take , nonTake);

    return dp[n] ; 
  } 

}