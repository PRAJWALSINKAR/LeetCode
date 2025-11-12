class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i : bloomDay) {
            low = Math.min(low, i);
            high = Math.max(high, i);
        }
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (helper(mid, bloomDay, m, k)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public boolean helper(int val, int[] arr, int m, int k) {
        int count = 0;
        int gucha = 0;

        for (int i : arr) {
            if (i <= val) {
                count++;
            } else {
                gucha += (count / k);
                count = 0;
            }
        }
        gucha += (count / k); 
        return gucha >= m;
    }
}