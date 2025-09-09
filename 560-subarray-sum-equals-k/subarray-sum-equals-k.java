class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for(int i = 0 ; i< n-1 ; i++){
            int sum =nums[i] ;
            if(sum == k)count++;
            for(int j = i+1 ;j<n ;j++){
                sum += nums[j];
                if(sum == k)count++;
            }
        }
        if(nums[n-1] == k)count++;
    return count;
    }
}