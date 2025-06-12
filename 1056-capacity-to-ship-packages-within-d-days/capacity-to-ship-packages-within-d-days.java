// MY approch
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int result = 0;
        int low = 0;
        int high = 0;
        for (int i : weights) {
            low = Math.max(low, i);
            high += i;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = helper(mid, weights);
            if (val <= days) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public int helper(int capacity, int[] weights) {
        int count = 1;
        int total_w = 0;
        for (int w : weights) {
            if (total_w + w > capacity) {
                count++;
                total_w = 0;
            }
            total_w += w;
        }
        return count;
    }
}
