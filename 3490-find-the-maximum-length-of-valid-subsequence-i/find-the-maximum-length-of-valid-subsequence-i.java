class Solution {
    public int maximumLength(int[] nums) {
        // Case 1: alternating parity → (a + b) % 2 == 1
        int maxAlt = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((prev + nums[i]) % 2 == 1) {
                maxAlt++;
                prev = nums[i];
            }
        }

        // Case 2: same parity → (a + b) % 2 == 0
        // Try both all even and all odd subsequences
        int evenCount = 0;
        int oddCount = 0;
        for (int num : nums) {
            if (num % 2 == 0) evenCount++;
            else oddCount++;
        }
        int maxSame = Math.max(evenCount, oddCount);

        return Math.max(maxAlt, maxSame);
    }
}
