class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row =0;
        int col = 0;
        while(row < m && col < n){
            if(matrix[row][col] == target)return true;

            if(row+ 1 < m && target >= matrix[row +1 ][col]){
                row++;
            }else{
                col++;
            }
            if(col >= n || matrix[row][col] > target)
            return false;
        }
        return false;
    }
}