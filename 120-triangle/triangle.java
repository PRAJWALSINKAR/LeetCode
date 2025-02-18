class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m]; // Using m since it's a triangle
        
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(0, 0, dp, triangle); // Start from the top of the triangle
    }

    public static int f(int row, int col, int[][] dp, List<List<Integer>> triangle) {
        int m = triangle.size();

        // Base case: last row
        if (row == m - 1) {
            return triangle.get(row).get(col);
        }
        if (dp[row][col] != -1) return dp[row][col];

        // Move down and diagonally down-left
        int down = f(row + 1, col, dp, triangle);
        int downLeft = f(row + 1, col + 1, dp, triangle);

        return dp[row][col] = triangle.get(row).get(col) + Math.min(down, downLeft);
    }
}
