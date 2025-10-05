class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;//row
        int n = heights[0].length;//

        boolean[][] paci = new boolean[m][n];
        boolean[][] atla = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, paci, heights);
            dfs(i, n - 1, atla, heights);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, paci, heights);
            dfs(m - 1, i, atla, heights);
        }
        List<List<Integer>> lis = new ArrayList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (paci[row][col] && atla[row][col]) {
                    lis.add(Arrays.asList(row, col));
                }
            }
        }
        return lis;

    }

    public void dfs(int i, int j, boolean[][] vis, int[][] heights) {
        if (vis[i][j])
            return;
        vis[i][j] = true;
        int[][] direction = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        for (int[] dir : direction) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row >= 0 && col >= 0 && row < vis.length && col < vis[0].length && vis[row][col] != true && heights[row][col] >= heights[i][j]) {
                dfs(row, col, vis, heights);
            }
        }
    }
}