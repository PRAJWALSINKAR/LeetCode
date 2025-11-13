class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        
        helper(0 , new ArrayList<>() , nums , ans);
        return ans;
    }
    public void helper(int ind , List<Integer> lis , int[] nums , List<List<Integer>> set){
        if(ind == nums.length  ){
            set.add(new ArrayList<>(lis));
            return;
        }
        if(ind > nums.length)return;
        lis.add(nums[ind]);
        helper(ind + 1  , lis , nums , set);
        lis.remove(lis.size() - 1);
        while(ind < nums.length-1 && nums[ind] == nums[ind +1])ind++;
        helper(ind +1 , lis , nums , set);
    }
}