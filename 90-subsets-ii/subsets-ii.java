class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        helper(0 , new ArrayList<>() , nums , set);

        for(List<Integer> i : set){
            ans.add(new ArrayList(i));
        }
        return ans;
    }
    public void helper(int ind , List<Integer> lis , int[] nums , Set<List<Integer>> set){
        if(ind == nums.length  ){
            set.add(new ArrayList<>(lis));
            return;
        }

        lis.add(nums[ind]);
        helper(ind + 1  , lis , nums , set);
        lis.remove(lis.size() - 1);
        helper(ind +1 , lis , nums , set);
    }
}