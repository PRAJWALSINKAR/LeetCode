class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        int [] dp = new int[n];
         dp[0] = nums[0];
         for(int i = 1;i< n ; i++){
           int  one = dp[i-1];
           int two = 0;
           if(i == 1){
            two = nums[i];
           }
            if(i>1){
            two =  nums[i]+ dp[i-2];
            }
            int pick = Math.max(one ,two);
            dp[i] = pick;
        
         }
         return dp[n-1];
        
    }
}