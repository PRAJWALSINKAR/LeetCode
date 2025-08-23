class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 != 0)return false;
        int target = sum/2;
        boolean [][]dp = new boolean[n][target+1];

        for(int i =0 ; i<n ;i++){
            for(int j =0;j<dp[0].length ; j++){
                if(j == 0 || j == nums[i]){
                    dp[i][j] =true;
                    continue;
                }
                if(i > 0 && dp[i-1][j] == true){
                    dp[i][j] = true;
                    continue;
                }
                if(i> 0 && j-nums[i] > 0 && dp[i-1][j-nums[i]] ==true){
                    dp[i][j] = true;
                    continue;
                }
            }
        }
        return dp[n-1][target];
    }
}