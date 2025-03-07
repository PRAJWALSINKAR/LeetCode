class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int target= 0;
        int sum=0;
        for(int i : nums ){
            sum += i ;
        }
        if(sum % 2 == 0){
            target = sum /2;
        }else{
            return false;
        }
        boolean [][] dp = new boolean[n][target+1];

        for(int i =0;i<n ;i++){
            dp[i][0] = true;
        }
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        for(int i = 1 ; i<n; i++){
            for(int j=1; j<= target ; j++){
                boolean notTake = dp[i-1][j];

                boolean take = false;
                if(j >= nums[i]){
                    take = dp[i-1][j-nums[i]];
                }
                if(take || notTake){
                    dp[i][j]=true;
                }else{
                    dp[i][j] = false;
                }
           }
        }
        return dp[n-1][target];
    }
}