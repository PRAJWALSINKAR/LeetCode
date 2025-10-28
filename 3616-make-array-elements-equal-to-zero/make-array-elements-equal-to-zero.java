class Solution {
    public int countValidSelections(int[] nums) {
        int sum = 0;
        int count = 0;
        int curr = 0;

        for (int i : nums)
            sum += i;

        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];

            if (nums[i] == 0) {
                if (2 * curr == sum) {
                    count += 2;
                } else if (Math.abs(sum - (2 * curr)) == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
