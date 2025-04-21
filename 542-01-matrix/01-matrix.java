 //   ------------------------- STRIVERS SOLUTION -------------------------
// Helper class to store row, col, and distance  
class Solution {
    static class Node {
    int row;
    int col;
    int dist;

    Node(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length; 
        int m = mat[0].length; 
        
        int[][] vis = new int[n][m]; 
        int[][] dist = new int[n][m]; 
        
        Queue<Node> q = new LinkedList<>();
        
        // Initialize queue with all cells that have 0
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        // 4 directions
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Node current = q.poll();
            int row = current.row;
            int col = current.col;
            int steps = current.dist;

            dist[row][col] = steps;

            for(int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Node(nrow, ncol, steps + 1));
                }
            }
        }
        return dist;
    }
}