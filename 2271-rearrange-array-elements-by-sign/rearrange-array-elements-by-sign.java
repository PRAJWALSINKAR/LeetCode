class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int pos = 0, neg = n / 2;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                count[pos++] = nums[i];
            } else {
                count[neg++] = nums[i];
            }
        }
       pos = 0;
       neg = n / 2;
        for (int i = 0; i < n; i++) {
            if (i%2 == 0) {
                nums[i] = count[pos++];
            } else {
                nums[i] = count[neg++];
            }
        }
        return nums;
    }
}
// time and space -- O(N)