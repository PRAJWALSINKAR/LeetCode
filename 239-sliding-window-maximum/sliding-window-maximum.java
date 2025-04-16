class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] arr = new int[len - k + 1];
        int start = 0;

        for (int i = 0; i < len; i++) {

            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);

            if (i >= k - 1) {
                arr[start++] = nums[dq.peekFirst()];
            }
        }
        return arr;
    }
}