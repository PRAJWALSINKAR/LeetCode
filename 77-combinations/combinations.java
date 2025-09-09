class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
            helper(1 , ans , new ArrayList<>() , k , n);
        return ans;
    }
    
    public void helper(int i ,List<List<Integer>> ans , List<Integer>temp ,int k ,int n  ){
        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int j = i ; j<= n ;j++){
            temp.add(j);
            helper(j+1 , ans , temp , k , n);
             temp.remove(temp.size() -1);
        }
    }
}