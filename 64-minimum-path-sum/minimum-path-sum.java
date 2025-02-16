class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(m - 1, n - 1, dp, grid);
    }

    public int helper(int row, int col, int[][] dp, int[][] arr) {
        if (row == 0 && col == 0) {
            return arr[row][col];
        }

        if (dp[row][col] != -1) return dp[row][col];

        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if (row > 0) {
            up = helper(row - 1, col, dp, arr);
        }
        if (col > 0) {
            left = helper(row, col - 1, dp, arr);
        }

        dp[row][col] = arr[row][col] + Math.min(up, left);

        return dp[row][col];
    }
}