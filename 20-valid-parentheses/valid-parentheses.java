class Solution {
    public boolean isValid(String s) {
      Stack<Character> ans = new Stack<>();
      for(int i = 0;i< s.length() ; i++){
        char c = s.charAt(i);

        if(c=='(' || c=='{' || c=='['){
            ans.push(c);
        }
        else{
            if(ans.size() == 0)return false;

            char top = ans.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        if(ans.size()== 0)return true;
        return false;
    }
}