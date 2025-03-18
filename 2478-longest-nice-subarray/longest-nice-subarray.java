class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLength =0;
        
        for(int i=0 ;i< nums.length ; i++){
            int valid = 0;
            for(int j = i ;j<nums.length ;j++){
                if((valid & nums[j])!=0){
                    break;
                }
                valid |= nums[j];
                maxLength = Math.max(maxLength , j-i+1);
            }
        }
        return maxLength;
    }
}