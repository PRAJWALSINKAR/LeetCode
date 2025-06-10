
//My aspproch

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                int left = leftSarch(0, mid , nums, target);
                int right = rightSarch(mid, n-1, nums, target);
                return new int[]{ left, right };
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
          return new int[] { -1, -1 };
    }

    public int leftSarch(int left, int right, int[] nums, int target) {
        int ans = -1;
        while (left <= right) {
            int mid  = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int rightSarch(int left, int right, int[] nums, int target) {
        int ans = -1;
        while (left <= right) {
            int mid  = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}


/* time = O(log n )
space = O(1)
*/