class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;        
        boolean [][] vis = new boolean[row][col];

        for(int i =0;i<row ; i++){
            for(int j=0;j<col ;j++){
                if(i == 0 || j ==  col-1|| j==0 || i== row-1 ){
                    dfs(i , j , board , vis);
                }
            }
        }
             for(int i =0;i<row ; i++){
                for(int j=0;j<col ;j++){
                    if(board[i][j] == 'O' && vis[i][j] == false){
                        board[i][j]= 'X';
                    }
                }
            }
        }

    public void dfs(int row, int col, char[][] board, boolean[][] vis) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return;

        if (board[row][col] == 'X' || vis[row][col]== true)
            return;

        vis[row][col] = true;

        dfs(row - 1, col, board, vis);
        dfs(row, col - 1, board, vis);
        dfs(row, col + 1, board, vis);
        dfs(row + 1, col, board, vis);

    }
}