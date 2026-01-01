class Solution {
    public int lengthOfLongestSubstring(String s) {
        int [] arr = new int[200];
        int left = 0;
        int right = 0;
        int n = s.length();
        int max =0;
        while(right < n){
            char ch = s.charAt(right);
            arr[ch]++;
            while(arr[ch] > 1){
                arr[s.charAt(left)]--;
                left++;
            }
            max = Math.max(max , right - left + 1);
            right++;
        }
        return max;
    }
}