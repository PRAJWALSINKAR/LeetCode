class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
         boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if(helper(0, i, j, board, word,vis))return true;
                }
            }
        }
        return false;
    }
    public boolean helper(int ind, int i, int j, char[][] board, String word , boolean[][]vis) {
        if (ind == word.length())
            return true;

        if (i < 0 || j < 0 ||i > board.length - 1 || j > board[0].length - 1)
            return false;

        if (word.charAt(ind) != board[i][j] || vis[i][j] == true)
            return false;
        vis[i][j] = true;
        //up
        boolean up = helper(ind + 1, i - 1, j, board, word,vis);
        //left
        boolean left = helper(ind + 1, i, j - 1, board, word,vis);
        // down
        boolean down = helper(ind + 1, i + 1, j, board, word,vis);
        //right
        boolean right = helper(ind + 1, i, j + 1, board, word,vis);

        vis[i][j] = false;
        
        return up || left || down || right; 
    }
}