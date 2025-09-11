class Solution {
    public int minimumRounds(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int x = helper(0, arr, dp);
        if (x >= Integer.MAX_VALUE - 500)
            return -1;
        return x;
    }

    public int helper(int ind, int[] arr, int[] dp) {
        if (ind >= arr.length)
            return 0;

        int take = Integer.MAX_VALUE;
        int notTake = Integer.MAX_VALUE;
        if (dp[ind] != Integer.MAX_VALUE)
            return dp[ind];
        if (ind + 1 < arr.length && arr[ind] == arr[ind + 1]) {
            take = 1 + helper(ind + 2, arr, dp);
        }
        if (ind + 2 < arr.length && arr[ind] == arr[ind + 2]) {
            notTake = 1 + helper(ind + 3, arr, dp);
        }
        if (take == Integer.MAX_VALUE && notTake == Integer.MAX_VALUE) {
            return dp[ind] = Integer.MAX_VALUE - 500;
        }
        return dp[ind] = Math.min(take, notTake);
    }
}