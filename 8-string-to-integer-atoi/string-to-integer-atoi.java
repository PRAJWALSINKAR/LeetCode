class Solution {
    public int myAtoi(String s) {
        int i = 0;
        long ans = 0;
        boolean sign = false;
        int n = s.length();
        // spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i < n && s.charAt(i) == '0') {
            i++;
            if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
                return 0;
            }
        }
        //sign
        if (i < n && s.charAt(i) == '-') {
            sign = true;
            i++;
        }

        if (i < n && s.charAt(i) == '+') {
            if (sign)
                return 0;
            i++;
            if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+'))
                return 0;
        }
        //zero 
        while (i < n && s.charAt(i) == '0') {
            i++;
        }
        //value
        while (i < n) {
            long val = s.charAt(i) - '0';
            if (val < 0 || val > 9)
                break;
            // Check for overflow before adding digit(gpt)
            if (ans > (Integer.MAX_VALUE - val) / 10) {
                return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = 10 * ans + val;
            i++;
        }
        if (sign) {
            if (ans > Integer.MAX_VALUE)
                return Integer.MIN_VALUE;
            return -1 * (int) ans;
        }
        if (ans >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int) ans;
    }
}