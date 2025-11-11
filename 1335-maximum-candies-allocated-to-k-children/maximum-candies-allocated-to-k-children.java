class Solution {
    public int maximumCandies(int[] candies, long k) {
       
        long low = 1;
        long high = 0;

        for(int i : candies){
            high = Math.max(i , high);
        }

        while(low <= high){
            long mid = low + (high-low) / 2;
            long count = 0;

            for(int i : candies){
                count += i/mid;
            } 

            if(count >= k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return (int)high;
    }
}