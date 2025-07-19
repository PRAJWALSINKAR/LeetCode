import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        Stack<Integer> stack = new Stack<>();

        for (int right = 0; right < n; right++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[right]) {
                int mid = stack.pop();
                if (stack.isEmpty())
                    break;

                int left = stack.peek();
           int minHeight = Math.min(height[right], height[left]) - height[mid];
                int width = right - left - 1;
                water += minHeight * width;
            }
            stack.push(right);
        }

        return water;
    }
}
