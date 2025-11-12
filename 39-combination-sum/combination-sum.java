class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0 , 0,target, candidates, new ArrayList() , ans);
        return ans;
    }

    public void helper(int ind , int curr , int target ,int [] arr ,  List<Integer> lis , List<List<Integer>> ans   ){
        if(ind >= arr.length || curr > target)return;
        if(target == curr){
            ans.add(new ArrayList<>(lis));
            return;
        }
        
        if(arr[ind]+curr <= target){
            lis.add(arr[ind]);
            helper(ind , curr + arr[ind] , target , arr , lis , ans);
              lis.remove(lis.size() -1 );
        }
        
      

        helper(ind+1 , curr, target , arr , lis , ans);
    }
}