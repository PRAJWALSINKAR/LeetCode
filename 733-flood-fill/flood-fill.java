class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
         if(color==image[sr][sc])
            return image;
        int x = image[sr][sc];
        dfs(image , sr , sc ,color , x );
        return image;
    }

    public void dfs(int [][] image , int row , int col ,int newColor , int x ){
        if(row >= image.length || col >= image[0].length || row < 0 || col < 0)return;

        if (image[row][col] != x) return;

        image[row][col] =  newColor;

        dfs(image,row-1,col,newColor,x);
        dfs(image,row+1,col,newColor,x);
        dfs(image,row,col-1,newColor,x);
        dfs(image,row,col+1,newColor,x);
    }
}