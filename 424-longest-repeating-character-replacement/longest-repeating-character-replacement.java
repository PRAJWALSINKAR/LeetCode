class Solution {
    public int characterReplacement(String s, int k) {
        int [] freq = new int[27];
        int left = 0;
        int right = 0;
        int maxl = 0;
        int maxCount = 0;
        for(right = 0 ; right < s.length() ; right++){
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            maxCount = Math.max(maxCount , freq[idx]);

            //imp here we shrik our window size
            if ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
         maxl = Math.max(maxl, right - left + 1);
        }
        return maxl;
    }
}