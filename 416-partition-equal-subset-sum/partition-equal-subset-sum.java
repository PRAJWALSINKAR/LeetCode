class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum=0;
        int target = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 ==0){
           target = sum/2;
        }else{
            return false;
        }
        boolean [][] dp = new boolean[n][target+1];
       
        for(int i=0 ;i<n ; i++){
            dp[i][0] = true;
        }
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        for(int i = 1 ; i< n ; i++){
            for(int j =1;j<=target ; j++){
                boolean notTaken = dp[i-1][j];
                boolean taken = false;

                if(j >= nums[i]){
                    taken = dp[i-1][j - nums[i]];
                }
                if(taken || notTaken){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n-1][target];
    }
}