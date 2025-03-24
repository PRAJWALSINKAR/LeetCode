class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums , k) - helper(nums ,k-1 );
    }
    public int helper(int [] nums , int k){
        if(k-1<0)return 0;
        Map<Integer , Integer> map = new HashMap<>();
        int left = 0;
        int right= 0;
        int count = 0;
        while(right < nums.length){
            map.put(nums[right],map.getOrDefault(nums[right] ,0)+1);
            
            while(map.size() > k){
               map.put(nums[left],map.getOrDefault(nums[left] ,0)-1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                    
                }
                left++;
            }
             count += right-left+1; 
             right++;
        }
        return count;
    }
}