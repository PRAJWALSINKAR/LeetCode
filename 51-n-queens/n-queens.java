class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] mat = new int[n][n];
        List<List<String>> res = new ArrayList<>();
        int count = n;
        helper(0, mat, res);
        return res;
    }

    public void helper(int j, int[][] mat, List<List<String>> res) {
        if (j == mat.length) {
            res.add(construct(mat));
            return;
        }
        for (int i = 0; i < mat.length; i++) {
            if (check(i, j, mat)) {
                mat[i][j] = 1;
                helper(j + 1, mat, res);
                mat[i][j] = 0;
            }
        }
    }

    public List<String> construct(int[][] mat) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] == 0) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }


    public boolean check(int i, int j, int[][] mat) {
       int m = i;
        int n = j;
        //left vertical
        while (i >= 0 && j >= 0) {
            if (mat[i][j] == 1)
                return false;
            i--;
            j--;
        }
        i = m;
        j = n;
        //right vertical
        while (j >= 0 && i < mat.length) {
            if (mat[i][j] == 1)
                return false;
            i++;
            j--;
        }
        i = m;
        j = n;
        //up
        while (j >= 0) {
            if (mat[i][j] == 1)
                return false;
            j--;
        }
        return true;
    }
}