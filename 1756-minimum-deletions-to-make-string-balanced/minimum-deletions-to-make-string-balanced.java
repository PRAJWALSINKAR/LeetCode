class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int right_a [] = new int[n];
        int left_b [] = new int[n];
        int counta = 0;
        int countb = 0;
        for(int i = 0; i<n ; i++){
            char chs = s.charAt(i);
            char chl = s.charAt(n-1-i);
            left_b[i] = countb;
            if(chs == 'b'){
                countb++;
            }
            right_a[n-1-i] = counta;
            if(chl == 'a'){
                counta++;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i< n ; i++){
            ans = Math.min(ans , right_a[i] + left_b[i]);
        }
        return ans;
    }
}