class Solution {
    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;;
        int max =0;
        for(int val : nums){
            min = Math.min(min , val);
            max = Math.max(max  , val);
        }
        int left = min;
        int right = max;
        int ans = Integer.MAX_VALUE;

        while(left <= right){
            int mid = left+(right-left)/2;
            if(helper(nums , k , mid)){
                 right = mid-1;
                ans = Math.min(ans , mid);
            }else{
                 left = mid+1;
                }
        }
        return ans;
    }
    public boolean helper(int [] nums, int k , int val){
        int count=0;
        int i =0;
        while(i < nums.length){
             if(nums[i] <= val){
                count++;
                i = i+2;
                continue;
             }else{
                i++;
             }
        }
        if(count >= k){
            return true;
        }
        return false;
    }  
}