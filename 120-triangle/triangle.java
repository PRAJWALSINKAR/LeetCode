class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer [][] dp = new Integer[n][triangle.get(n-1).size()];
        return helper(0 ,0,triangle , dp);
    }
    public int helper(int row , int col , List<List<Integer>> triangle , Integer[][] dp){

        if(col > triangle.get(row).size() -1 )return Integer.MAX_VALUE-500; 
        if(row == triangle.size()-1)return triangle.get(row).get(col);

        if(dp[row][col] != null)return dp[row][col];


        int down = triangle.get(row).get(col) + helper(row+1 ,col,triangle, dp); 
        
        int right = triangle.get(row).get(col) + helper(row+1 ,col + 1,triangle , dp);

        return dp[row][col] = Math.min(down , right);
    }
}