class Solution {
    public int maximumEnergy(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];// to store a sums 

        for (int i = 0; i < n; i++) {
            if (i < k) { // if previous steps not possible
                dp[i] = arr[i];
            } else {
                dp[i] = Math.max(arr[i], arr[i] + dp[i - k]);// we take previous sum and current max
            }
        }
        
        int ans = Integer.MIN_VALUE;
        
        for (int j = n - 1; j >= n-k; j--) { // loop for cheaking last value k values
            ans = Math.max(ans, dp[j]);
        }
        
        return ans;
    }
}