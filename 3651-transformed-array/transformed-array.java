class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];

        for(int i = 0 ; i< n ; i++){
            int steps = Math.abs(nums[i]);
            int ind = i;

            while(steps > 0){
                if(nums[i] > 0){
                    ind = (ind + 1) % n ;
                }else{
                    ind = (ind - 1 +n) %n; // gpt
                }
                steps--;
            }
            ans[i] = nums[ind];
        }
        return ans;
    }
}