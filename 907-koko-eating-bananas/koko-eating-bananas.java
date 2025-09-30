class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int max : piles){
            high = Math.max(high , max);
        }
        while(low < high){
            int count =0;
            int mid = low + (high-low ) / 2;
            for(int i : piles){
                count += Math.ceil((double)i/(double)mid);
            }
            if(count <= h){
                high = mid;
            }
            else{
                low = mid +1;
            }
        }
        return low;
    }
}