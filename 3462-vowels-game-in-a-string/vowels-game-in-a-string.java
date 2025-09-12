class Solution {
    public boolean doesAliceWin(String s) {
       String vow = "aeiou";

       for(int i =0 ; i< s.length() ;i++){
        char ch = s.charAt(i);
        if(ch=='a' ||ch=='u'||ch=='i'||ch=='e'||ch=='o' )return true;
       }
       return false;
    }
}