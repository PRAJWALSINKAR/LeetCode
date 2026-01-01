class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        if(bloomDay.length < m*k)return -1;
        for(int i : bloomDay){
            low = Math.min(low , i);
            high = Math.max(high , i);
        }
        int res =-1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(helper(mid , bloomDay , m , k)){
                high = mid -1;
                res = mid;
            }else{
                low = mid +1;
            } 
        }
        
        return res;
    }

    public boolean helper(int day , int[] arr , int need , int flower){
        int total = 0;
        int count =0;
        for(int i : arr){
            if(i <= day){
                count++;
            }
            if(count == flower){
                count = 0;
                total++;
            }
            if(i > day)count =0;
        }
        return total >=need;
    }
}