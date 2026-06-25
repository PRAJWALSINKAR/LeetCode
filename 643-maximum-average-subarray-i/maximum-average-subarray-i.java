class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double curr =0;
        double n = nums.length;
        double ans =Integer.MIN_VALUE;
        for(int i = 0 ; i < k-1 && i < n ; i++){
            curr += nums[i];
        }
        int i = 0;
        for(int j = k-1 ; j < n ; j++){
            curr += nums[j];
            ans = Math.max(ans , curr / k );
            curr -= nums[i++];
        }
        return ans;
    }
}