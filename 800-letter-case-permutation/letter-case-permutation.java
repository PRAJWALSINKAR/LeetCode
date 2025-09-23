class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        helper(0 , s , ans , "");
        return ans;
    }
    public void helper(int ind , String s , List<String> ans , String t){
        if(ind == s.length()){
            ans.add(t);
            return;
        }
        char ch = s.charAt(ind);
        if(ch - '0' < 10){
            helper(ind+1 , s , ans , t + ch);
        }else{

            helper(ind +1 , s , ans , t + Character.toLowerCase(ch));
            helper(ind +1 , s , ans , t + Character.toUpperCase(ch));
        }
    }
}