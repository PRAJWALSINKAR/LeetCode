class Solution {
    public int pivotIndex(int[] nums) {
    int maxSum = 0;
    for(int i = 0 ; i< nums.length ; i++){
         maxSum += nums[i]; 
    }
    int currSum = 0;
    for(int i =0 ; i<nums.length ;i++){
         int right = maxSum - currSum - nums[i];
         if(currSum == right){
         return i;
         }
         currSum += nums[i];
        } 

   return -1;
    }
}