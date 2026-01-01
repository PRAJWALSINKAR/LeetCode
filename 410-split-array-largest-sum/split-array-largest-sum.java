class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for(int i : nums){
            high += i ;
            low = Math.max(low, i); 
        }
        
        while(low <= high){
            int mid = low + (high - low) /2 ;

            if(helper(mid , nums , k)){
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    public boolean helper(int day , int [] nums , int need ){
        int sum = 0;
        int count =1;

        for(int i : nums){
            if(i+sum > day){
                sum = i;
                count++;
            }else{
                sum +=i;
            }
        }
        return count > need;
    }
}