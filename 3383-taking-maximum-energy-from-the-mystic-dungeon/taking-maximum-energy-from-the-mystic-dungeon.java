class Solution {
    public int maximumEnergy(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < k) {
                dp[i] = arr[i];
                continue;
            }
            dp[i] =Math.max(arr[i] ,  arr[i] + dp[i - k]);
        }
        int ans = Integer.MIN_VALUE;
        for (int j = n - 1; j >= 0; j--) {
            if (k == 0)
                break;
            ans = Math.max(ans, dp[j]);
            k--;
        }
        return ans;
    }
}