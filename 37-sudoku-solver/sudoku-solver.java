class Solution {
    public void solveSudoku(char[][] board) {
        int n = board.length;
         helper(n , board);
    }

public boolean helper(int n ,  char [][] board){
    for(int i=0;i<n;i++){
        for(int j = 0; j< n ; j++){
            if(board[i][j] =='.'){
                for(char k ='1'; k<='9'; k++){
                    if(valid(i,j, k ,board)){
                        board[i][j] = k; 

                    if(helper(n,board)==true){
                    return true;
                    }else{
                        board[i][j]='.';
                        }    
                    }
                }
                return false;
                }
            }
        } 
        return true;  
    }
  public boolean valid(int row , int col , int value, char [][]board){
    for(int i =0; i<9;i++ ){
        if(board[row][i] == value)return false;

        if(board[i][col]  == value)return false;
  
        if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == value)
        return false;
        }
        return true;
    }
}