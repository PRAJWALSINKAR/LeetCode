class Solution {
    public int[] rearrangeArray(int[] nums) {
           int n = nums.length;
        int[] newArray = new int[n];

        int positive = 0;
        int negative = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                newArray[positive] = nums[i];
                positive = positive + 2;
            } else {
                newArray[negative] = nums[i];
                negative = negative + 2;
            }
        }
        return newArray;

    }
}
// time  and space  --- O(N) 