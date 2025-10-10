class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] arr = new long[n];
        long[] prev = new long[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    arr[j] = prev[j] + (skill[j] * mana[i]);
                    continue;
                }
                arr[j] = Math.max(prev[j], arr[j - 1]) + (skill[j] * mana[i]);
            }
            if (i > 0) {
                for (int k = n - 2; k >= 0; k--) {
                    arr[k] = arr[k + 1] - (skill[k + 1] * mana[i]);
                }
            }
            prev = arr;
        }
        return prev[n - 1];
    }
}