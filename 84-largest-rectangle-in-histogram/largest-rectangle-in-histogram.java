class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int n = heights.length;
        int element = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int next = n;
            int prev = -1;
            while (!stk.isEmpty() && heights[i] < heights[stk.peek()]) {
                next = i;
                element = heights[stk.pop()];
                if (!stk.isEmpty()) {
                    prev = stk.peek();
                } else {
                    prev = -1;
                }
                max = Math.max(max, element * (next - prev - 1));
            }
            stk.push(i);
        }
        while (!stk.isEmpty()) {
            int next = n;
            int prev = -1;
            element = heights[stk.pop()];
            if (!stk.isEmpty()) {
                prev = stk.peek();
            } else {
                prev = -1;
            }
            max = Math.max(max, element * (next - prev - 1));
        }
        return max;
    }
}