class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, sum = 0, k = 0;
        int[] cnt = new int[n + 1];

        for (int i = 0; i < n; i++) {
            while (sum + cnt[i] < nums[i]) {
                if (k == queries.length) return -1;

                int l = queries[k][0];
                int r = queries[k][1];
                int val = queries[k][2];
                k++;

                if (r < i) continue;
                cnt[Math.max(l, i)] += val;
                if (r + 1 < n) {
                    cnt[r + 1] -= val;
                }
            }
            sum += cnt[i];
        }
        return k;
    }
}