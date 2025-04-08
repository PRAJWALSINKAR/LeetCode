class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stk = new Stack<>();
    for(int i = 0 ; i< n ; i++){
        char ch = s.charAt(i);
        if(ch == '(' || ch == '[' || ch == '{') stk.push(ch);
        else{
        if(stk.isEmpty())return false;

        if(ch == ')' && stk.peek() =='(') stk.pop();
       else if(ch == ']' && stk.peek() =='[') stk.pop();
       else if(ch == '}' && stk.peek() =='{') stk.pop();
       else return false;
        }
    }
    if(stk.isEmpty())return true;

    return false;
    }
}