class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if(n != m)return false;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < m ; j++){
                if(s.charAt((i+j) % n) != goal.charAt(j))break;
                if(j == m-1)return true;
            }
        }
        return false;
    }
}