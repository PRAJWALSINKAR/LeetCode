class Solution {
    public int minimumTotal(List<List<Integer>> arr) {
        int n = arr.size();
        int[][] dp = new int[n][n];
        for(int [] zp : dp){
            Arrays.fill(zp , Integer.MAX_VALUE);
        }
        return helper(0, 0, dp, arr);
    }

    public int helper(int row, int col, int[][] dp, List<List<Integer>> arr) {
        if (row == arr.size() - 1)
            return arr.get(row).get(col);

        if (dp[row][col] != Integer.MAX_VALUE)return dp[row][col];

        int down = helper(row + 1, col, dp, arr);
        int rightDown = helper(row + 1, col + 1, dp, arr);

        dp[row][col] = arr.get(row).get(col) + Math.min(down, rightDown);

        return dp[row][col];
    }
}