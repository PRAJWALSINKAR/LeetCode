class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int dp[][]= new int [m][n];
        for(int [] arr: dp){
            Arrays.fill(arr,-1);
        }
        return helper(m-1 , n-1 , s1, s2 , dp);
    
    }

    public int helper(int ind1 , int ind2 , String s1 , String s2 , int[][]dp){
        if(ind1 < 0)return  ind2+1;

        if(ind2 < 0 )return ind1+1;
        
        if(dp[ind1][ind2] != -1)return dp[ind1][ind2];
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return dp[ind1][ind2] = helper(ind1 -1 ,ind2-1 , s1,s2, dp);
        }
        int insert = 1 + helper(ind1 , ind2 -1 , s1 ,s2 ,dp);
        int delet = 1 + helper(ind1 - 1 , ind2  , s1 ,s2 ,dp);
        int replace = 1 + helper(ind1 -1, ind2 -1 , s1 ,s2 ,dp);

        return dp[ind1][ind2] = Math.min(insert , Math.min(delet , replace));
    }
}