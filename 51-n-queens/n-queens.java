class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] queen = new char[n][n];

        boolean[] leftRight = new boolean[2 * n + 1];
        boolean[] rightLeft = new boolean[2 * n + 1];
        boolean[] column = new boolean[n + 1];
        List<String> temp = new ArrayList<>();

        canPlace(0, leftRight, rightLeft, column, queen, ans);
        return ans;
    }

    private void canPlace(int row, boolean[] leftRight, boolean[] rightLeft, boolean[] column, char[][] queen,
            List<List<String>> ans) {
        int n = queen.length;
        if (row == n) {
            ans.add(new ArrayList<>(helper(queen)));
            return;
        }

        for (int col = 0; col < queen.length; col++) {
            if (!(leftRight[n + (col - row)] || rightLeft[col + row] || column[col])) {

                leftRight[n + (col - row)] = true;
                rightLeft[col + row] = true;
                column[col] = true;
                queen[row][col] = 'Q';

                canPlace(row + 1, leftRight, rightLeft, column, queen, ans);
                queen[row][col] = '.';
                leftRight[n + (col - row)] = false;
                rightLeft[col + row] = false;
                column[col] = false;
            }
        }
    }

    public List<String> helper(char[][] queen) {
        List<String> temp = new ArrayList<>();
        int n = queen.length;
        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = 0; j < n; j++) {
                if (queen[i][j] == 'Q') {
                    str = str + "Q";
                } else {
                    str = str + ".";
                }
            }
            temp.add(str);
        }
        return temp;

    }
}
