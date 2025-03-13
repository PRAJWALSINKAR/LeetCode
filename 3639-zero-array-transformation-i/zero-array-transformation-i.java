class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int [] dp = new int[n+1];

        for(int i = 0 ;i< queries.length;i++){
           dp[queries[i][0]]--;
           dp[queries[i][1] + 1]++; 
        }

        int diff = 0;

        for(int i = 0 ;i< n ; i++){
            diff += dp[i];

            if((nums[i] + diff) >0){
                return false;
            }
        }
        return true;
    }
}