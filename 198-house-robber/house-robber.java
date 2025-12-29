class Solution {
    public int rob(int[] nums) {
       
        int n  = nums.length;
        if(n== 1)return nums[0];
        int prev = Math.max(nums[0] ,  nums[1]);
         int prev2 = nums[0];

        for(int i = 2  ; i < n ; i++){
              int max = Math.max(prev , nums[i] + prev2);
              prev2 = prev;
              prev = max;
        }
       return prev;

    }
}