class Solution {
    public int longestSubarray(int[] nums) {
        int count = 1;
        int ans = 0;
        int i = 0;
        int j = 0;
        int n = nums.length;

        while(j < n){
            if(nums[j] == 0)count--;
            while(count < 0){
                if(nums[i] == 0)count++;
                i++; 
            }
            ans = Math.max(ans , j-i);
            j++;
        }
        return ans;
    }
}