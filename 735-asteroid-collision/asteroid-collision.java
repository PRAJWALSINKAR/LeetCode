class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> stk = new Stack<>();

        for (int i : nums) {
            if (i > 0) {//positive push diretcly,bcoz no colligion
                stk.push(i);
            } else {
                while (!stk.isEmpty() && stk.peek() > 0) {

                    if (stk.peek() < Math.abs(i)) {
                        stk.pop();
                        continue;
                    } else if (stk.peek() == Math.abs(i)) {
                        stk.pop();
                        i=0;
                        break;
                    } else {
                        i = 0; // right astroid explosed
                        break;
                    }
                }
                if (i != 0) {
                    stk.push(i);
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