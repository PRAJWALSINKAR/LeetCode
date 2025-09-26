class Solution {
    int ans =0;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int start = 0;
        int end = 0;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    start = i;
                    end = j;
                    
                }if(grid[i][j] == -1){
                    count++;
                }
            }
        }
    helper(start , end , m*n-count-1 , vis , grid);
    return ans;
    }

    public void helper(int row , int col , int tsq , int[][] vis , int[][] grid){
        if(row < 0 || col < 0 || row > grid.length-1 || col > grid[0].length-1 || vis[row][col] == 3  || grid[row][col] == -1 )return;

        if(tsq==0 && grid[row][col] == 2){
         ans++;
         return;
        }
 
       
        vis[row][col] = 3;
        tsq--;
        
        helper(row-1 ,col , tsq , vis , grid);

        helper(row ,col-1 , tsq , vis , grid);

        helper(row+1 ,col , tsq , vis , grid);

        helper(row ,col+1 , tsq , vis , grid); 
        vis[row][col] =0;
    }
}