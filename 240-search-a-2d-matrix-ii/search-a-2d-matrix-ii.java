class Solution {
    public boolean searchMatrix(int[][] mat, int t) {
        int m = mat.length;
        int n = mat[0].length;
        int row = 0;
        int col = n-1;

        while(row < m && col >= 0){
            if(mat[row][col] == t)return true;

            if(mat[row][col] > t){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}