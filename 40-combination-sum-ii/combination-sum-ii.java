class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        helper(0 , target , arr ,new ArrayList() ,  ans);
        return ans;
    }
    public void helper(int ind , int target , int [] arr , List<Integer> lis , List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(lis));
            return;
        }

        if(ind >= arr.length || target < 0 )return;


        if(target - arr[ind] >= 0){
            lis.add(arr[ind]);
            helper(ind +1 , target - arr[ind] , arr , lis , ans);
            lis.remove(lis.size() - 1);
            while(ind < arr.length-1 && arr[ind]==arr[ind+1]){ind++;}
       }
        
        helper(ind +1 , target, arr , lis , ans);
    }
}