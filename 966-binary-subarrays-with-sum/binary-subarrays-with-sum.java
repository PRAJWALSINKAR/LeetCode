class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
     return helper(nums , goal) - helper(nums , goal-1);
    }
    public int helper(int [] nums , int k){
        int left = 0;
        int sum = 0;
        int count = 0;

        for(int right=0 ;right< nums.length;right++){
            if(k < 0)return 0;
            sum += nums[right];

            if(sum > k) {
                while(sum > k){
                    sum -= nums[left];
                    left++; 
                }
            }
            count += right - left +1;
        }

        return count;
    }
}