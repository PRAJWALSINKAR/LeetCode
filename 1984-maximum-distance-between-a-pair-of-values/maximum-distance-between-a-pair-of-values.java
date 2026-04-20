class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        //my approch loop + binary search
        int ans = Integer.MIN_VALUE;
        int k = nums2.length - 1;
        int n1 = nums1.length - 1;
        int target;
        while (k >= 0) {
            target = nums2[k];
            int low = 0;
            int high = n1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (nums1[mid] <= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            if (low <= k && nums1[low] <= target) {
                ans = Math.max(ans, k - low);
            }
            k--;
        }
        if(ans == Integer.MIN_VALUE)return 0;
        return ans;
    }
}
//optiomal Approch
/*
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int ans = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                ans = Math.max(ans, j - i);
                j++;
            } else {
                i++;
            }
        }
        return ans;
    }
}
*/