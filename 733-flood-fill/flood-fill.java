class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
         if(color==image[sr][sc])
            return image;
        int originalColor = image[sr][sc];
        dfs(image , sr , sc ,color , originalColor );
        return image;
    }

    public void dfs(int [][] image , int row , int col ,int newColor , int originalColor ){
        if(row >= image.length || col >= image[0].length || row < 0 || col < 0)return;

        if (image[row][col] != originalColor) return;

        image[row][col] =  newColor;

        dfs(image,row-1,col,newColor,originalColor);
        dfs(image,row+1,col,newColor,originalColor);
        dfs(image,row,col-1,newColor,originalColor);
        dfs(image,row,col+1,newColor,originalColor);
    }
}