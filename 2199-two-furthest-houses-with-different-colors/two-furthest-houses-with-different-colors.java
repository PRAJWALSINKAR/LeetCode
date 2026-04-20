class Solution {
    public int maxDistance(int[] nums) {
       int n = nums.length;
        int max = 0;

        for(int i = n - 1; i >= 0; i--) {
            if(nums[i] != nums[0]) {
                max = Math.max(max, i);
                break;
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(nums[i] != nums[n - 1]) {
                max = Math.max(max, n - 1 - i);
                break;
            }
        }

        return max;
    }
}