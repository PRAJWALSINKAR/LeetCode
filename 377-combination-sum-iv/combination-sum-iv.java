class Solution {
    public int combinationSum4(int[] nums, int target) {
       Integer dp [] = new Integer[target + 1];
      return  helper(0 , nums , target , dp);
    }
    
    public int helper(int ind , int [] nums , int t, Integer [] dp){
        if(t == 0)return 1;

        if(t < 0)return 0;
        if(dp[t] != null)return dp[t];
        int c = 0;
        for(int i = 0 ; i < nums.length ; i++){
            c += helper(i , nums , t - nums[i], dp);
        }

        return dp[t] = c;
    }
}