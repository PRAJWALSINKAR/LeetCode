class Solution {
    public int rob(int[] nums) {
        int n = nums.length ;
        if(n==2)return Math.max(nums[0], nums[1]);
        int [] dp = new int[n];
        Arrays.fill(dp , -1);
        return helper(n-1 , nums , dp );
    }

    public int helper(int n , int [] nums , int [] dp){
        
        if(n <0)return 0;
        
           
        if(dp[n] != -1)return dp[n];
        int take = helper(n-2, nums, dp) + nums[n];
        int not_take = helper(n-1 , nums ,dp) ;

        dp[n] = Math.max(take , not_take);

        return dp[n];
    }
}