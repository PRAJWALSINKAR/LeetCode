class Solution {
    public String largestOddNumber(String num) {
        // my approch
        int n = num.length();
        for(int i = n-1 ; i >=0 ; i--){
            char ch = num.charAt(i);
            if((ch - '0') % 2 != 0){
                return num.substring(0 , i+1); 
            }
        }
     return "";
    }
}
/*
TIme = O(N)
Space = O(N)
*/