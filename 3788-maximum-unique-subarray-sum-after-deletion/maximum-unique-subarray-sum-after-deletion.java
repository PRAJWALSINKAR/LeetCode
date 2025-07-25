class Solution {
    public int maxSum(int[] nums) {
        if(nums.length == 1)return nums[0];
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        if (max < 0)
            return max;

        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }
 

        Arrays.sort(nums);
        max = nums[0];
        for (int i = 1  ; i< nums.length  ; i++) {
          if(nums[i-1] == nums[i]){
          continue;
          }
          max += nums[i]; 
        }

        return max;
    }
}