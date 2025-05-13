class Solution {
    public int splitArray(int[] nums, int k) {
 int low = 0, high = 0;

        for (int num : nums) {
            low = Math.max(low, num); 
            high += num;              
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int currentSum = 0;
        int splits = 1;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                splits++;
                currentSum = num;
                if (splits > k) return false;
            } else {
                currentSum += num;
            }
        }

        return true;
    }
}