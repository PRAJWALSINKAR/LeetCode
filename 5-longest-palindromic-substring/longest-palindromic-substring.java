class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (s == null && n == 0)
            return "";

        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int odd_Center = expand(s, i, i); // Odd length palindrome :-> aba
            int even_Center = expand(s, i, i + 1);// Even length palindrome :-> abba
            int max = Math.max(odd_Center, even_Center);

            //for calculating new start and end points
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    //here we just go left side and right side and camparing it 
    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
/*
Time: O(n²) → Due to expansion for every character
Space: O(1) → No extra space used
*/