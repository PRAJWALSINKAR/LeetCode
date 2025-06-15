//my approch
class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
            return i;
            }
        }
        return -1;
    }
}
/*
Time Complexity: O(n × m)
Space Complexity: O(1) (excluding temporary substring memory)
*/