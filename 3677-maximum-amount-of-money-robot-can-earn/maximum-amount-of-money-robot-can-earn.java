class Solution {
    public int maximumAmount(int[][] coins) {
        Integer[][][] dp = new Integer[coins.length][coins[0].length][3];
        return helper(0, 0, 2, coins, dp);
    }

    public int helper(int row, int col, int neutral, int[][] arr, Integer[][][] dp) {
        if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length)
            return Integer.MIN_VALUE / 2;

        if (row == arr.length - 1 && col == arr[0].length - 1) {
            if (neutral > 0 && arr[row][col] < 0) return 0;
            return arr[row][col];
        }

        if (dp[row][col][neutral] != null) return dp[row][col][neutral];

        int right = Integer.MIN_VALUE;
        if (arr[row][col] < 0 && neutral > 0) {
            int take    = helper(row + 1, col, neutral - 1, arr, dp);
            int nonTake = arr[row][col] + helper(row + 1, col, neutral, arr, dp);
            right = Math.max(take, nonTake);
        } else {
            right = arr[row][col] + helper(row + 1, col, neutral, arr, dp);
        }

        int down = Integer.MIN_VALUE;
        if (arr[row][col] < 0 && neutral > 0) {
            int take    = helper(row, col + 1, neutral - 1, arr, dp);
            int nonTake = arr[row][col] + helper(row, col + 1, neutral, arr, dp);
            down = Math.max(take, nonTake);
        } else {
            down = arr[row][col] + helper(row, col + 1, neutral, arr, dp);
        }

        return dp[row][col][neutral] = Math.max(right, down); 
    }
}