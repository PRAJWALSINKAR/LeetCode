class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0 ; i<n-2 ; i++){
            if(i > 0 && nums[i]  == nums[i-1])continue;
            int j = i+1;
            int k = n-1;
            while(j<k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> lis = new ArrayList<>();
                    lis.add(nums[i]);
                    lis.add(nums[j]);
                    lis.add(nums[k]);
                    ans.add(lis);
                    while(j < k && nums[j] == nums[j+1])j++;
                    while(j < k && nums[k] == nums[k-1])k--;
                 }
                if(nums[j] + nums[k] + nums[i] > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return ans;
    }
}