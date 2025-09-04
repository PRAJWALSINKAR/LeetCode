class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int prev = nums[n-1];
        int curr = nums[n-1];
        
        for(int i = n-2 ;i>=0 ; i--){
             curr =Math.max(nums[i], nums[i] + curr);

            prev = Math.max(curr , prev);
        }
        return prev;
    }
}