class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean [][] vis = new boolean[m][n];
        for(int i = 0 ; i< m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(word.charAt(0) == board[i][j]){
                    if(helper(0, i , j , vis , board , word))return true;
                }
            }
        }
        return false; 
    }
    public boolean helper(int ind ,int row , int col , boolean [][] vis , char[][] board , String s){
        if(ind == s.length())return true;

        if(row < 0 || col < 0 || row >= vis.length || col >= vis[0].length)return false;

        if(vis[row][col] == true ||  board[row][col] != s.charAt(ind))return false;

        vis[row][col] =true;

        boolean up = helper(ind+ 1 , row -1, col , vis , board , s );

        boolean down = helper(ind+ 1 , row +1 , col , vis , board , s );

        boolean left = helper(ind+ 1 , row , col-1 , vis , board , s );

        boolean right = helper(ind+ 1 , row , col + 1 , vis , board , s );

        vis[row][col] = false;
        return up || down || left || right;


    }
}