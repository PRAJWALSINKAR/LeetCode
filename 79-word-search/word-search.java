class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;//ROW
        int n = board[0].length;//COL
         int ind = 0;

         for(int i = 0;i<m;i++){
               for(int j = 0 ; j<n; j++){
                   if(board[i][j] == word.charAt(ind)){
                     if(helper(i , j ,m , n ,  ind , board , word )){
                    return true;         
                    }
                 }
            }
       }
       return false;  
    }
     public boolean helper(int row , int col ,int m , int n , int ind , char [] [] board , String word){
        if(ind == word.length()){
            return true;
        }
        if(row == m || col == n ||  row<0 || col<0  || board[row][col] == '!' ||  board[row][col] != word.charAt(ind)){
           return false;
        }
        char ch =board[row][col];
          board[row][col]= '!';

        boolean top = helper(row-1 , col ,m , n ,  ind+1 , board , word );

         boolean bottom = helper(row+1 , col ,m , n ,  ind+1 , board , word );
         
         boolean left = helper(row , col-1 ,m , n ,  ind+1 , board , word );

         boolean right = helper(row , col+1 ,m , n ,  ind+1 , board , word );

        board[row][col] = ch;
         
         return top || bottom || left || right;
     }
    
}