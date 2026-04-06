class Solution {
    public boolean judgeCircle(String s) {
       int x = 0 , y = 0;
       for(int i = 0 ; i< s.length() ; i++){
        char ch = s.charAt(i);
        if(ch == 'U')x--;
        if(ch == 'D')x++;
        if(ch == 'L')y--;
        if(ch == 'R')y++;
       }
       return (x == 0 && y==0);
    }
}