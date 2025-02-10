class Solution {
    public int maxSubArray(int[] nums) {
        int max =Integer.MIN_VALUE;
        int currMax = 0;
        for(int i =0 ; i< nums.length ; i++ ){
              currMax = currMax + nums[i];
            if(max < currMax){
                max = currMax;
            }
            if(currMax < 0){
               currMax = 0;
            }
        }
        return max;
    
    }
}