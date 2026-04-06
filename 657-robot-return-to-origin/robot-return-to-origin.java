class Solution {
    public boolean judgeCircle(String s) {
       int x = 0 , y = 0;
       for(int i = 0 ; i< s.length() ; i++){
        char ch = s.charAt(i);
        if(ch == 'U')y++;  // +y axis
        if(ch == 'D')y--;  // -y axis
        if(ch == 'L')x--;  // -x axis
        if(ch == 'R')x++;  //  +x axis 
       }
       return (x == 0 && y==0);

       
    }
}