class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> lis  = new ArrayList<>();
        helper(0 ,0 ,n*2 ,lis , "");
        return lis;
    }
    public void helper(int op , int cl , int len , List<String> lis , String s){
        if(s.length() == len ){
            lis.add(s);
            return;
        }
        if(op < len/2)
        helper(op +1 ,cl, len , lis , s + "(");
        if(op > cl)
        helper(op ,cl+1 ,len , lis , s+")");
    }
}