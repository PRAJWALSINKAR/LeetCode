class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1 , 0 , 0 , new ArrayList<>(),  k , n , res);
        return res; 
    }
    public void helper(int val , int idx ,int sum ,List<Integer> temp ,  int k , int n ,  List<List<Integer>> res ){
        if(idx == k && sum == n){
            res.add(new ArrayList<>(temp));
            return ;
        }
        if(val == 10 || sum > n || idx > n ) return;

        temp.add(val);
        helper(val+1 , idx+1,sum+val,temp,k,n,res);

        temp.remove(temp.size() - 1);
        helper(val+1, idx , sum , temp , k , n,res);
    }
}