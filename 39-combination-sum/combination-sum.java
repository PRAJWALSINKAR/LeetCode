class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0 , target , new ArrayList<>() , ans , candidates );
        return ans;
    }

    public void helper(int ind ,int target , List<Integer> lis ,List<List<Integer>> ans , int [] arr  ){
        if(target == 0 ){
            ans.add(new ArrayList<>(lis));
            return;
        }
        if(ind >= arr.length)return;

        if(target - arr[ind] >= 0){
            lis.add(arr[ind]);
            helper(ind , target - arr[ind] , lis , ans , arr);
             lis.remove(lis.size() -1);
        }

        helper(ind+1 , target , lis , ans , arr);
        

    }
}