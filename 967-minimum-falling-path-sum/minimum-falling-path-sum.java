class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] prev = new int[m];
        int[] cur = new int[m];

        // Initialize the first row
        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + prev[j];

            int leftDiagonal = (j - 1 >= 0) ? matrix[i][j] + prev[j - 1] : matrix[i][j] + Integer.MAX_VALUE -1000;
            int rightDiagonal = (j + 1 < m) ? matrix[i][j] + prev[j + 1] : matrix[i][j] + Integer.MAX_VALUE- 1000;

            

                // Store the minimum of the three paths in cur
                cur[j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
            // Update prev for the next row
            prev = cur.clone();
        }

        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, prev[j]);
        }

        return mini;
    }
}
