class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int i : nums)sum +=i;

        int leftSum = 0;
        int[] ans = new int[n];

        for(int i = 0 ; i< n ; i++){
            sum -= nums[i];
            ans[i] = Math.abs(sum - leftSum);
            leftSum += nums[i];
        }
        return ans;
    }
}