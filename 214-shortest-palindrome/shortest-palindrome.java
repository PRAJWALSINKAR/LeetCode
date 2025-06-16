//brute approch
class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        for(int i = 0 ;i < s.length() ; i++){
            
            if(s.startsWith(rev.substring(i))){
                return rev.substring(0 , i) + s;
            }
        }
        return "";
    }
}

/*
Time Complexity: O(n²) – Due to startsWith() inside a loop.
Space Complexity: O(n) – For the reversed string and result.
*/