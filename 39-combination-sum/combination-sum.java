class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> res = new ArrayList<>();
       helper(0 , candidates , target , new ArrayList<>() ,res);
       return res;
    }
    public void helper(int ind , int [] arr , int target , List<Integer> temp ,List<List<Integer>> res  ){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(ind == arr.length)return;

        if(target >= arr[ind]){
            temp.add(arr[ind]);
            helper(ind , arr , target - arr[ind] , temp , res);
            temp.remove(temp.size() -1);
        }
        helper(ind+1 , arr , target , temp , res);

    }
}