class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start =0;
        int end = 0;

        for(int i = 0 ; i< n ; i++){
            int odd = helper(i , i , s);
            int even = helper(i , i+1 , s);

            int max = Math.max(odd , even);
            if(max > end - start){
              start = i - (max -1)/2;
              end = max/2 +i ; 
           }
        }
        return s.substring(start , end+1);

    }
    public int helper(int i , int j , String s ){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j -i-1;
    }
}