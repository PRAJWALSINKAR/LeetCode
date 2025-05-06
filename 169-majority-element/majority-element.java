class Solution {
    public int majorityElement(int[] nums) {
        int k = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == k) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    k = nums[i];
                    count = 1;
                }
            }
        }
        return k;
    }
}
/* 
time complixity -> O(N) -> iterate  one
space complixity -> O(1) --> use contants only
*/