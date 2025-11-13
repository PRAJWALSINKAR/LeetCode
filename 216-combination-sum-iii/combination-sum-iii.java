class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0 , new ArrayList<>() , k , n, ans);
        return ans;
    }
    public void helper(int ind , List<Integer> lis , int len , int target, List<List<Integer>> ans){

        if(len == lis.size()){
            if (target == 0)
            ans.add(new ArrayList<>(lis));
            return;
        }

        if(lis.size() >= len || target <= 0 )return;

        for(int i = ind+1 ; i < 10 ; i++){
            if(target - i < 0)break;
            lis.add(i);
            helper(i , lis , len , target - i , ans);
            lis.remove(lis.size() - 1);
        }
    }
}