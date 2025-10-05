class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int n = matrix.length;
       int m = matrix[0].length;
       int row = 0;
       int col = m-1;

       while(row < n && col >=0){
        if(matrix[row][col] == target)return true;

        if(target < matrix[row][col]){
            col--;
        }else{
            row++;
        }
       } 
       return false;
    }
}