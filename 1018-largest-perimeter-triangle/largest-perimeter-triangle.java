class Solution {
    public int largestPerimeter(int[] nums) {
        //The sum of the two smaller sides must be strictly greater than the largest side
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;
        for (int i = n - 1; i >= 2; i--) {

            if (nums[i] < (nums[i-1] + nums[i-2])) {
               return nums[i] + nums[i-1] + nums[i-2];
            }
           
        }
        return 0;
    }
}