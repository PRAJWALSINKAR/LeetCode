class Solution {
     int count =0;
    public int totalNQueens(int n) {
        int [][] mat = new int[n][n];
        helper(0 , mat , n);
        return count;
    }
    public void helper(int row , int [][] mat , int n ){
        if(row == n){
          count++;
          return;
        }
        for(int i = 0 ; i < n ;i++){
            if(valid(row, i , mat)){
                mat[row][i] = 1;
                helper(row+1 , mat , n);
                mat[row][i] =0;
            }
        }
    }
    public boolean valid(int row , int col , int [][]mat){
        int m = row;
        int n = col;
   
        while(row >= 0 && col >= 0){
            if(mat[row][col] == 1)return false;
            row--;
            col--;
        }

        row = m;
        col = n;
        while(row >= 0){
            if(mat[row][col] == 1)return false;
            row--;
        }

        row = m;
        col = n;
        while(row >= 0 && col < mat.length){
            if(mat[row][col] == 1)return false;
            row--;
            col++;
        }
        return true;
    }
}