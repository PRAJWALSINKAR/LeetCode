class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        int dp[][] = new int[n][n];
        for(int [] arr : dp){
            Arrays.fill(arr , Integer.MAX_VALUE  - 500);
        }
        return helper(0 , 0  , tri , dp);
    }
    public int helper(int row , int col , List<List<Integer>> tri , int[][] dp){
        if(row == tri.size() -1){
            return tri.get(row).get(col);
        }
        if(dp[row][col] < Integer.MAX_VALUE  - 500)return dp[row][col];
        int d = helper(row+1 ,col ,tri,dp);
        int dl = helper(row +1 ,col +1 , tri,dp);

        return dp[row][col] = tri.get(row).get(col) + Math.min(d , dl);
    }
}