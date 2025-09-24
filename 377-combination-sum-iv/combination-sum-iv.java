class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];
        return helper(nums, target, dp);
    }

    private int helper(int[] nums, int target, Integer[] dp) {
        if (target == 0) return 1; 
        if (dp[target] != null) return dp[target];

        int ways = 0;
        for (int num : nums) {
            if (target - num >= 0) {
                ways += helper(nums, target - num, dp);
            }
        }
        return dp[target] = ways;
    }
}
