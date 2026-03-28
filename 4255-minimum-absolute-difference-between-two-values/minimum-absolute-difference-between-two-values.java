class Solution {
    public int minAbsoluteDifference(int[] nums) {
       int i = 0 ;
       int j = 1;
       int n = nums.length;
       int ans = Integer.MAX_VALUE;
       if(n < 2)return -1;
        while(j < nums.length){
            if((nums[i] == 1 && nums[j] == 2 )|| (nums[i] == 2 && nums[j] == 1)){
                ans = Math.min(ans , Math.abs(i-j));
                i=j;
            }else if(nums[j] == 1 || nums[j] == 2){
                i=j;
            }

            j++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans ;
    }
}