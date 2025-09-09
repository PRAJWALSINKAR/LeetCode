class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(nums);
        for(int i =0 ; i< n-2 ; i++){
            int j = i+1 ;
            int k = n-1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                int currdiff = Math.abs(sum - target);

                if(currdiff < diff){
                    ans = sum;
                    diff = currdiff;
                }
                if(sum > target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return ans;
    }
}