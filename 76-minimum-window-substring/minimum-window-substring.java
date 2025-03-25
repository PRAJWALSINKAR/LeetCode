class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int count = t.length();
        int left = 0, right = 0, minStart = 0;
      int  minlen = Integer.MAX_VALUE;
        int[] arr = new int[128];
        for (char c : t.toCharArray()) {
            arr[c]++;
        }

        while (right < s.length()) {
            if (arr[s.charAt(right)] > 0) {
                count--;
            }
                 arr[s.charAt(right)]--;

            while (count == 0) {
                if (right - left + 1 < minlen) {
                    minStart = left;
                    minlen = right - left + 1;
                }
                arr[s.charAt(left)]++;
                if (arr[s.charAt(left)] > 0) {
                    count++;
                }
                left++;
            }
            right++;
        }
        if(minlen == Integer.MAX_VALUE)return "";
        return s.substring(minStart , minStart + minlen);
    }
}