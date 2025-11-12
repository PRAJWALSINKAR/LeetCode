class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> lis = new ArrayList<>();
        helper("" ,  0,0, n , lis);
        return lis;
    }
    public void helper(String s , int op ,int cl ,  int n , List<String> lis){
        if(op == n && cl == n){
            lis.add(s);
            return;
        }
        if(op < n){
            helper(s + '(' , op+1 ,cl, n , lis);
        }
        if(cl < op)
        helper(s+')' , op , cl+1 ,  n , lis);
    }
}