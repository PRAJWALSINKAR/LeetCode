class Solution {
    public long subArrayRanges(int[] nums) {
        return SumMax(nums) - SumMin(nums);
    }

    // maximum element in all sunArray
    public long SumMax(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] <= nums[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        long total = 0;

        for (int i = 0; i < n; i++) {
            total = (total + (long) (i - left[i]) * (right[i] - i) * nums[i]);
        }
        return total;
    }

    public long SumMin(int [] nums){
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] > nums[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        long total = 0;

        for (int i = 0; i < n; i++) {
            total = (total + (long) (i - left[i]) * (right[i] - i) * nums[i]);
        }
        return total;
    }
}
