class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
         if(n == 1)return nums[0];
        int prev = Math.max(nums[1] , nums[0]);
        int last_prev = nums[0];

        for(int i = 2 ; i<n ; i++){
           int best = Math.max(prev , nums[i] +last_prev);
           last_prev = prev;
           prev = best;
        }
        return prev;
    }
}