class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (haystack.substring(i, j).equals(needle))
                    return i;
            }
        }
        return -1;
    }
}