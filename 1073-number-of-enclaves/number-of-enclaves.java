class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                    dfs(i, j, vis, grid);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1 && vis[i][j] == false)count++;
            }
        }
        return count;
    }

    public void dfs(int row , int col , boolean [][] vis , int [][] grid){
        if(row<0 || col <0 || row >= grid.length || col >= grid[0].length)return;

        if(grid[row][col] == 0 || vis[row][col] ==true)return;
        
        vis[row][col] = true;

       dfs(row +1  , col , vis , grid);
       dfs(row , col +1 , vis , grid);
       dfs(row , col-1 , vis , grid);
       dfs(row -1 , col , vis , grid);

    }
}