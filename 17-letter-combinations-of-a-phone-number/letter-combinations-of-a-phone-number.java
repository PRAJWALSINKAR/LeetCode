class Solution {
    public List<String> letterCombinations(String digits) {
        String [] ch = {"" , "", "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz" };
        List<String> ans = new ArrayList<>();
        helper(0 , "" , ch , digits ,  ans);
        return ans;
    }

    public void helper(int ind , String s , String [] ch , String arr , List<String> ans){
        if(s.length() == arr.length()){
            ans.add(s);
            return;
        }
        if(ind >= arr.length())return;

        String curr = ch[arr.charAt(ind) - '0'];

        for(int i = 0 ; i< curr.length() ; i++ ){
            helper(ind+1 , s + curr.charAt(i) , ch ,arr , ans );
        }
    }
}