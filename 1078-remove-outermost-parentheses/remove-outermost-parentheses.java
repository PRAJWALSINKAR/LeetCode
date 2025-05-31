class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                if (count > 1) {
                    sb.append('(');
                }
            } else {
                if (count > 1) {
                    sb.append(')');
                }
                 count--;
            }
        }
        String sp = sb.toString();
        return sp;
    }
}