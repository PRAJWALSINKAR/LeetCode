class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int i =0 ;i<n ;i++){
           sum += nums[i];
        }
        if(sum % 2 != 0)return false; 
        int target = sum /2;
        int[][] dp = new int[n][target+1];
        for(int [] arr : dp){
            Arrays.fill(arr , -1);
        }
        return helper(0 , target , nums , dp);
    }
    public boolean helper(int ind , int target , int [] nums , int[][]dp){
       
        if(target == 0)return true;
        if(target < 0 || ind  >= nums.length)return false;

        if(dp[ind][target] != -1){
            if(dp[ind][target] == 0){
                return true;
            }else{
                return false;
            }
        }
        boolean take = helper(ind +1 , target - nums[ind], nums , dp );
        boolean nontake = helper(ind +1 , target , nums , dp );

        if(take || nontake){
            dp[ind][target] = 0;
        }else{
            dp[ind][target] = 1;
        }
        return take || nontake;
    }
}