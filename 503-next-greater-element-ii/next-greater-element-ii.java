class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = n * 2 - 1; i >= 0; i--) {
            int curr = nums[i % n];
            while (!stk.isEmpty() && curr >= stk.peek()) {
                stk.pop();
            }
            if (i < n) {
                if (!stk.isEmpty()) {
                    ans[i] = stk.peek();
                }
            }
            stk.push(curr);
        }
        return ans;
    }
}