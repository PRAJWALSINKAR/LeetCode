class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int maxl = 0;
        int count = 0;
        for(right = 0; right <nums.length ; right++ ){
            if(nums[right] == 0)count++;

            if(count > k){
                while(count > k){
                    if(nums[left] == 0)count--;
                
                left++;
                }
            }
            maxl = Math.max(maxl , right - left + 1);
        }
        return maxl;
    }
}