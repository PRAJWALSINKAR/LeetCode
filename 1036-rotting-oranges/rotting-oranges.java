class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid[0].length == 0)
            return -1;
        int n = grid.length;
        int m = grid[0].length;
        int[][] time = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                time[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    dfs(i, j, 0, grid, time);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (time[i][j] == Integer.MAX_VALUE) {
                        return -1;
                    }
                    max = Math.max(max, time[i][j]);
                }
            }
        }
        return max;
    }

    public void dfs(int i, int j, int currTime, int[][] grid, int[][] time) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || currTime >= time[i][j])
            return;

        time[i][j] = currTime;

        dfs(i - 1, j, currTime + 1, grid, time);
        dfs(i + 1, j, currTime + 1, grid, time);
        dfs(i, j - 1, currTime + 1, grid, time);
        dfs(i, j + 1, currTime + 1, grid, time);
    }
}