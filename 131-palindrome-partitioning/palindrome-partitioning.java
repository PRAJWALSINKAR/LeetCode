class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(0 , new ArrayList<>() , s , ans);
        return ans; 
    }
    public void helper(int ind , List<String> lis , String s , List<List<String>> ans){
        if(ind == s.length()){
            ans.add(new ArrayList<>(lis));
            return;
        }

        for(int i = ind + 1 ; i <= s.length() ; i++){
            if(isPalidrome(ind , i-1 , s)){
                lis.add(s.substring(ind , i));
                helper(i , lis , s , ans);
                lis.remove(lis.size() - 1);
            }
        } 
    }
    public boolean isPalidrome(int low , int high , String s){
        while(low <= high){
            if(s.charAt(low) != s.charAt(high) )return false;
            low++;
            high--;
        }
        return true;
    }
}