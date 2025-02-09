class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        if(n==1){
            return 0;
        }
        for(int i =0;i<n ;i++){
          for(int j = 0 ;j< n ;j++){
           if(i == n-1 && j == n-2 ){
             if(s.charAt(i) != s.charAt(j)){
                return i;
             }
           }
            if(i == j){
                continue;
            }
            if(s.charAt(i) == s.charAt(j)){
                break;
            }
            if(j == n-1 && s.charAt(i) != s.charAt(j)){
                return i;
            }
          }
        }
          return -1;
    }
}