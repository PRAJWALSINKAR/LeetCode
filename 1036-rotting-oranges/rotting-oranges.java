class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int freshOrange = 0;
        Queue<Pair<Integer, Integer>> que = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    que.add(new Pair<>(i, j));
                }
                if (grid[i][j] == 1)
                    freshOrange++;
            }
        }
        int min = 0;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!que.isEmpty() && freshOrange > 0) {
            int size = que.size();
            min++;

            for (int i = 0; i < size; i++) {
             int r = que.peek().getKey();
             int c = que.peek().getValue();
             que.remove();

                for (int[] diraction : dir) {
                  int rr = r + diraction[0];
                  int cc = c + diraction[1];

                  if(cc >= 0 && cc <col && rr >= 0 && rr < row && grid[rr][cc] ==1){
                    grid[rr][cc] = 2;
                    freshOrange--;
                    que.add(new Pair<>(rr,cc));
                  } 
                }
            }
        }
        return freshOrange == 0 ? min :-1;
    }
}