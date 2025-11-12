class Solution {
    public int maxPathScore(int[][] grid, int k) {
       int m = grid.length;
       int n = grid[0].length;
       int dp[][][] = new int[m][n][k+1];
       for(int [][] arr : dp){
          for(int [] x : arr)Arrays.fill(x , -1);
       }
       int ans = helper(0 , 0 , 0 , grid , k  , dp );
       if(ans < 0)return -1;
       return ans; 
    }

    public int helper(int row , int col , int score , int [][] grid , int k , int [][][] dp ){
        if(row >= grid.length || col >= grid[0].length || k < 0)return Integer.MIN_VALUE;

        if(row == grid.length - 1 && col == grid[0].length -1 ){
            return score + grid[row][col];
        }
        if(dp[row][col][k] != -1)return dp[row][col][k];
        int downCost = 0 ;
        int RCost = 0;

        if( row + 1 < grid.length && col < grid[0].length && (grid[row+1][col] > 0))downCost++;
        if( row  < grid.length && col +1  < grid[0].length && (grid[row][col+1] > 0))RCost++;

        int down =  grid[row][col]+ helper(row+1 , col , score  , grid , k - downCost , dp);

        int right = grid[row][col]+ helper(row , col+1 , score , grid , k - RCost , dp);
         
        int ans = Math.max(right , down);
        if(ans < 0) ans = Integer.MIN_VALUE; 
        return dp[row][col][k] = ans;
    }
}