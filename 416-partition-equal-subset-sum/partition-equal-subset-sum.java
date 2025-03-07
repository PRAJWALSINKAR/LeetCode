class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int target=0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 ==0){
            target = sum / 2;
        }else{
            return false;
        }
        int [][] dp = new int[n][target+1];
        for(int i = 0 ;i<n ; i++){
            Arrays.fill(dp[i] , -1);
        } 
     return helper(n-1 , target , nums , dp);
    }
    public boolean helper(int ind , int target , int[] nums, int [][] dp){
        if(target == 0){
            return true;
        }
        if(ind == 0){
            return target==nums[0];
        }
        if(dp[ind][target] != -1){
            return dp[ind][target]==1;
       }
       boolean notTaken = helper(ind-1,target , nums,dp);
       boolean taken = false;
       if(target >= nums[ind]){
        taken = helper(ind-1,target-nums[ind] , nums, dp);
       }
       if(taken || notTaken){
        dp[ind][target] = 1;
       }else{
        dp[ind][target] = 0;
       }
       return dp[ind][target]==1;
    }
}