class Solution {
    public int countCollisions(String s) {
        int i = 0;
        for( ; i<s.length() ; i++ ){
            if(s.charAt(i) != 'L')break;
        }
        int ans = 0;
        int prev =0;
        for(; i<s.length() ; i++){
            char ch =s.charAt(i);
            if(ch == 'S'){
                ans += prev;
                prev = 0;
            }else if(ch == 'L'){
                ans += (prev +1);
                prev = 0;
            }else{
                prev++;
            }
        }
        return ans;
    }
}