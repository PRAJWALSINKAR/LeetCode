class Solution {
    public int rob(int[] nums) {
        int first = 0;
        int n = nums.length;
        if(n == 1)return nums[0];
        int prev2 = 0;
        int prev = nums[0];
        for(int i = 1 ; i < n -1; i++){
            int temp  = Math.max(prev , prev2 + nums[i]);
            prev2 = prev;
            prev = temp;
        }
        first = prev;

        int sec = 0;
        prev2 = 0;
        prev = nums[1];

        for(int i = 2 ; i < n ; i++){
            int temp  = Math.max(prev , prev2 + nums[i]);
            prev2 = prev;
            prev = temp;
        }
        sec = prev;


        return Math.max(first , sec);

    }
}