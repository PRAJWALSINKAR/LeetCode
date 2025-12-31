class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    boolean [][] vis = new boolean[image.length][image[0].length];
      helper(sr , sc , image[sr][sc] , color , image , vis );
      return image;
    }

    public void helper(int row , int col , int req , int color , int [][] arr , boolean [][] vis){
        if(row < 0 || col < 0 || row >= vis.length || col >= vis[0].length || arr[row][col] != req || vis[row][col])return;

        arr[row][col] = color;
        vis[row][col] =true;
        helper(row + 1 , col , req , color , arr , vis);

        helper(row  , col -1  , req , color , arr , vis);

        helper(row  , col +1 , req , color , arr , vis);

        helper(row - 1 , col , req , color , arr , vis);
    }
}