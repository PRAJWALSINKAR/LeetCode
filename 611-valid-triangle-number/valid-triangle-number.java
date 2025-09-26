//Valid Triangle means if you added length of any 2 side it will be greater than 3rd side length
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] > nums[k])
                        ans++;
                }
            }
        }
        return ans;
    }
}