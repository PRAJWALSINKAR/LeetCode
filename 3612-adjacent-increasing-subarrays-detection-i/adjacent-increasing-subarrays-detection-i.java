class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prev = 0;
        int inc =1;

        for(int i=1 ; i< nums.size() ; i++){
            if(nums.get(i-1) < nums.get(i)){
                inc++;
            }else{
                prev = inc;
                inc = 1;
            }
            if(inc/2 >= k   || Math.min(prev , inc) >= k)return true;
        }
        return false;
    }
}