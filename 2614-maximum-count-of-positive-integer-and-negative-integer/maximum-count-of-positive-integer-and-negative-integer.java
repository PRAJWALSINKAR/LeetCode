class Solution {
    int low= 0 ;
    public int maximumCount(int[] nums) {
        int n = nums.length;

        int neg = helperneg(low , n-1 , nums)  ;
        int pos = n  - helperpos(low,n-1 , nums );
        return Math.max(neg , pos);
    }

    public int helperneg(int low , int high , int [] nums){
        while(low <= high){
            int mid = low + (high - low)  / 2 ;
            
            if(nums[mid] < 0){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return low;
    }

    public int helperpos(int low , int high , int [] nums){
        while(low <= high){
            int mid = low + (high - low)  / 2 ;
            
            if(nums[mid] <=  0){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return low;
    }

}