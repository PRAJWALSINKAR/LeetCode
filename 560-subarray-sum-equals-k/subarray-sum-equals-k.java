class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i =0 ; i< nums.length ; i++){
        int sum = 0 ;
         sum += nums[i];
         if(sum == k){
            count++;
         }
         if(i == nums.length -1)break;
         for(int j = i+1; j < nums.length ; j++){
            sum += nums[j];
            if(sum == k){
                count++;
            }
         }
        }
         return count;
    }
}