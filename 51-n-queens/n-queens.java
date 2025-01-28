class Solution {
    public List<List<String>> solveNQueens(int n) {
        char [][] board = new char[n][n];
          for(int i=0;i<n;i++){
            for(int j = 0; j< n ; j++){
                board[i][j] ='.';
            }
          }
        List<List<String>> res = new ArrayList<>();
        helper(0,res , board );
        return res;
    }
    public void helper(int col , List<List<String>> res ,char[][] board) {
        if(col == board.length){
         res.add(Construct(board));
         return ;
        }
         for(int row = 0;row<board.length;row++){
        if(validate(board,row,col)){
            board[row][col]='Q';
            helper(col+1, res, board);
            board[row][col] ='.';
        }
      }
    }
  
   public  List<String> Construct(char[][] board){
       List<String > res = new ArrayList<>();
        for(int i = 0;i<board.length;i++){
          String ch = new String(board[i]);
            res.add( ch);
           }          
        
        return res;
    }


    public boolean validate(char[][] board, int row , int col){
    int dulrow = row;
    int dulcol = col;
    while(col >=0 && row>=0 ){
        if(board[row][col]=='Q') return false;
            col--;
            row--;
        }
    row = dulrow;
    col = dulcol;
    while(col >= 0){
        if(board[row][col] =='Q')return false;
        col--;
    }
    row = dulrow;
    col = dulcol;
    while(col>=0 && row < board.length){
        if(board[row][col] == 'Q') return false; 
        col--;
        row++; 
    }
       return true;
    }
}