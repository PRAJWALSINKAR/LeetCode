class Solution {
    public boolean isMatch(String s, String p) {
     int n = s.length();
     int m = p.length();
     Boolean[][] dp = new Boolean[n][m];

     return helper(n-1 , m-1 , dp , s , p);
    }
    public boolean helper(int i , int j , Boolean[][] dp , String s, String p){
        if(i < 0 && j < 0)return true;
        if( j < 0)return false;
        if(i < 0){
            while(j>=0){
                if(p.charAt(j) == '*'){
                    j--;
                }else{
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j] != null)return dp[i][j];
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j]  = helper(i-1 , j-1 , dp , s , p);
        }
        if(p.charAt(j) == '*'){
            return dp[i][j] = helper(i-1 , j , dp , s , p) || helper(i , j-1 , dp , s , p);
        }
        return dp[i][j] = false;
    }
}