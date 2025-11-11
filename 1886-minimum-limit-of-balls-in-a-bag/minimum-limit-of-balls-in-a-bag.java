class Solution {
    public int minimumSize(int[] nums, int k) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        

        while(low <= high){
            int mid = low + (high - low ) / 2 ;
            int count = 0;
            for(int i : nums){
                count += (i-1) / mid;
            }

            if(count <= k){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return low;
    }
}