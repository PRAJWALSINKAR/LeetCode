class Solution {
    public long maxRunTime(int n, int[] arr) {
        long low = 1;
        long high = 0; 
        for(int i : arr){
            high += i;
        }
        long ans = 0;
        while(low <= high){
            long mid = low + (high- low)  / 2;
            if(helper(mid , n , arr)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    public boolean helper(long x , long n , int [] arr){
       long sum = 0;
       long val = x*n;
       for(int i : arr){
        sum += Math.min(x , i);
       }
       return sum >= val;
    }
}