class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int n = nums.length; 
        for(int i : nums)sum +=i;
        int dp[][] = new int[n][(sum+1)*2];
        for(int arr[] : dp){
            Arrays.fill(arr ,-1);
        }
        return helper(0 , 0 ,sum ,  target , nums ,dp);  
    }
    public static int helper(int ind , int currSum ,int sum , int target , int[] nums ,int[][]dp){
        if(ind == nums.length){
            if(currSum == target){
                return 1;
            }else{
               return 0;
            }
        }
        if(dp[ind][sum + currSum] != -1)return dp[ind][sum+currSum];

        int pos = helper(ind +1 , currSum+nums[ind] , sum , target , nums , dp);
        int neg = helper(ind +1 , currSum - nums[ind] , sum , target , nums , dp);

        dp[ind][currSum + sum] = pos + neg;

        return dp[ind][currSum + sum] ;
    }
}