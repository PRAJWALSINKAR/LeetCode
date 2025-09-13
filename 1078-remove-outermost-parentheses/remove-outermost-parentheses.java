class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stk = new Stack<>();
        StringBuilder str = new StringBuilder();
        
        int start = 0; // To track start of primitive
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push('(');
            } else {
                stk.pop();
                if (stk.isEmpty()) {
                    // Add inner part (exclude outermost '(' and ')')
                    str.append(s.substring(start + 1, i));
                    start = i + 1; // update start for next primitive
                }
            }
        }
        return str.toString();
    }
}
