class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        
        int res = 0;
        int[] arr = new int[128];
        int start = 0;
        for (int end = 0; end < n; end++){
            char ch = s.charAt(end);
            start = Math.max(start, arr[ch]);
            res = Math.max(res, end - start + 1);
            arr[ch] = end + 1;
        }
        return res;
    }
}