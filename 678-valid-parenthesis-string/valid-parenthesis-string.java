class Solution {
    public boolean checkValidString(String s) {
        int left = 0;

        // First pass: left to right
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '*') left++;
            else left--;
            if (left < 0) return false;
        }

        int right = 0;

        // Second pass: right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ')' || ch == '*') right++;
            else right--;
            if (right < 0) return false;
        }

        return true;
    }
}
