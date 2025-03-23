class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    public int helper(int[] nums, int k) {//1
        if (k < 0) return 0;
        int left = 0;
        int ans = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) {
                count++;
            }
            if (count > k) {
                while (count > k) {
                    if (nums[left] % 2 != 0) {
                        count--;
                    }
                    left++;
                }
            }
          
            ans += right-left+1;
        }
        return ans;
    }
}