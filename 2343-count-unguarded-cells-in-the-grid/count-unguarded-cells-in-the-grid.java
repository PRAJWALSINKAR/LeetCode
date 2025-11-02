class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] arr = new int[m][n];
        for (int[] temp : guards) {
            arr[temp[0]][temp[1]] = 1;
        }
        for (int[] temp : walls) {
            arr[temp[0]][temp[1]] = 2;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    helper(i, j, arr);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                   ans++;
                }
            }
        }
        return ans;
    }

    public void helper(int row, int col, int[][] arr) {
        int dupr = row;
        int dupc = col;
        int n = arr.length;
        int m = arr[0].length;

        //up
        row--;
        while (row >= 0) {
            if (arr[row][col] == 1 || arr[row][col] == 2)
                break;
            arr[row][col] = 3;
            row--;
        }
        row = dupr;
        // down
        row++;
        while (row < n) {
            if (arr[row][col] == 1 || arr[row][col] == 2)
                break;
            arr[row][col] = 3;
            row++;
        }
        row = dupr;
        // left
        col--;
        while (col >= 0) {
            if (arr[row][col] == 1 || arr[row][col] == 2)
                break;
            arr[row][col] = 3;
            col--;
        }

        col = dupc;
        col++;
        while (col < m) {
            if (arr[row][col] == 1 || arr[row][col] == 2)
                break;
            arr[row][col] = 3;
            col++;
        }
    }
}