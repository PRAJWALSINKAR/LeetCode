class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        String arr = s + '*' +  rev;
        int x = s.length() - kmp(arr);
        String start = rev.substring(0, x);
        return start + s;
    }

    public int kmp(String rev){
        int n = rev.length();
        int [] arr = new int[n];

        int i = 0;
        int j = 1;

        while(j < n){
            if(rev.charAt(i) == rev.charAt(j)){
                arr[j] = i+1;
                i++;
                j++;
               
            }else if(i > 0){
               i = arr[i-1];
            }else{
                arr[j] = 0;
                j++;
            }
        }
        return arr[n-1];
    }
}