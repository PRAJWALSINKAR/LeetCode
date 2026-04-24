class Solution {
    public int furthestDistanceFromOrigin(String s) {
        int count = 0;
        int ans = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == 'L'){
                ans++;
            }else if(ch == '_'){
                count++;
            }
            else{
                ans--;
            }
        }
        return Math.abs(ans) + count;
    }
}