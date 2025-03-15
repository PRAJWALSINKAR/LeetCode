class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for(int i : candies){
            sum += i;
        }
        long low = 1;
        long result= 0;
        long high = sum /k;
      

        while(low <= high){
            long count = 0;
            long mid = (low + high) / 2;
            
            for(int i : candies){
                count += i/mid;
            }
            if(count >=k){
                low = mid+1;
                result = mid;
            }else{
                high = mid -1;
            }
        } 
        return (int)result;
    }
}