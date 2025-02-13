class Solution {
    public boolean rotateString(String s, String goal) {
        // If lengths are not equal, goal cannot be a rotation of s
        if (s.length() != goal.length()) return false;

        // Concatenate s with itself
        String doubled = s + s;

        // Use KMP algorithm to check if goal is a substring of doubled
        return kmpSearch(doubled, goal);
    }

    // KMP Algorithm: Checks if pattern is a substring of text
    private boolean kmpSearch(String text, String pattern) {
        int[] lps = buildLPS(pattern); // Build the LPS (Longest Prefix Suffix) array
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    return true; // Full match found
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1]; // Use LPS to avoid re-checking
                } else {
                    i++;
                }
            }
        }
        return false; // No match found
    }

    // Build the LPS (Longest Prefix Suffix) array for KMP
    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1]; // Fall back
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}