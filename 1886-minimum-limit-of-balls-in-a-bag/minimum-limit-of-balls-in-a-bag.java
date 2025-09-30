class Solution {
    public int minimumSize(int[] nums, int op) {
        int low = 1;
        int high =0;
        for(int i : nums){
            high = Math.max(high , i);
        }
        while(low <  high){
            int mid = low + (high-low) /2;
            if(isPossible(nums ,op , mid )){
                high = mid ;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public boolean isPossible(int [] nums , int op , int k){
        int totalop = 0;
        for(int val : nums){
            if(val % k == 0 ){
                totalop += (val/k)-1;
                continue;    
            }
            totalop += val/k;
        }
        return totalop <= op;
    }
}