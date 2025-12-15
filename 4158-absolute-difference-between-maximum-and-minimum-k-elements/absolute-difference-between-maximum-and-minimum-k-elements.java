class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0;
        int min = 0;
        int n = nums.length;
        for(int i = 0 ; i<k ; i++){
           max += nums[i];
           min += nums[n-1-i];
        }
        return Math.abs(min - max);
    }
}