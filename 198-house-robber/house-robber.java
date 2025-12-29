class Solution {
    public int rob(int[] nums) {
        Integer [] dp = new Integer[nums.length];
       return helper(0 ,dp  , nums);
    }
    public int helper(int ind ,Integer[] dp ,  int [] arr){
        int n = arr.length;
        if(ind >= n)return 0;

        if(dp[ind] != null)return dp[ind];

        int take = arr[ind] + helper(ind + 2 ,dp ,  arr);

        int notTake = helper(ind + 1 ,dp ,  arr);

        return dp[ind] = Math.max(take , notTake); 

    }
}