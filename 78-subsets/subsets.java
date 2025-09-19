class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0 , new ArrayList<>() , res , nums);
        return res;
    }
    public void helper(int ind , List<Integer> temp , List<List<Integer>> res , int[] nums){
        if(ind == nums.length){ 
             res.add(new ArrayList<>(temp));
             return;
        }
        temp.add(nums[ind]);
        helper(ind+1 , temp , res , nums);

        temp.remove(temp.size() - 1);
        helper(ind+1 , temp , res , nums);
            
    }
}