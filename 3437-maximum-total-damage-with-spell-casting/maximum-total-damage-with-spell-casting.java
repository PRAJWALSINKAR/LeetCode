class Solution {
    public long maximumTotalDamage(int[] power) {
        // Step 1: Count frequency of each power value
        Map<Integer, Long> freq = new HashMap<>();
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0L) + 1);
        }

        // Step 2: Sort unique power values
        List<Integer> uniquePowers = new ArrayList<>(freq.keySet());
        Collections.sort(uniquePowers);

        int n = uniquePowers.size();
        long[] dp = new long[n];

        // Base case
        dp[0] = freq.get(uniquePowers.get(0)) * uniquePowers.get(0);

        // Step 3: Dynamic Programming
        for (int i = 1; i < n; i++) {
            int currPower = uniquePowers.get(i);
            long currDamage = (long) currPower * freq.get(currPower);

            // Find last valid index where power ≤ currPower - 3
            int prevIdx = findPreviousValid(uniquePowers, i - 1, currPower - 3);

            if (prevIdx >= 0) currDamage += dp[prevIdx];

            dp[i] = Math.max(dp[i - 1], currDamage);
        }

        return dp[n - 1];
    }

    // Binary search helper to find previous non-conflicting power
    private int findPreviousValid(List<Integer> powers, int end, int target) {
        int low = 0, high = end, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (powers.get(mid) <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
