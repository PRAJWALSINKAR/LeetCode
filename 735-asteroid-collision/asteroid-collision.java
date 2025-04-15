class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> stk = new Stack<>();

        for (int i : nums) {
            if (i > 0) {
                stk.push(i); // Positive direction, no collision
            } else {
                while (!stk.isEmpty() && stk.peek() > 0) {
                    if (stk.peek() < -i) {
                        stk.pop(); // Smaller right asteroid explodes
                        
                    } else if (stk.peek() == -i) {
                        stk.pop(); // Equal size: both explode
                        i = 0;
                        break;
                    } else {
                        // Left asteroid is smaller, it explodes
                        i = 0;
                        break;
                    }
                }
                if (i != 0) {
                    stk.push(i); // Push surviving left asteroid
                }
            }
        }

        int n = stk.size();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = stk.pop();
        }
        return ans;
    }
}
