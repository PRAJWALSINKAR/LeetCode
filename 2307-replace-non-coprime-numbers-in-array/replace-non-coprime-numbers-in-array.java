class Solution {
    long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Long> st = new Stack<>();

        for (int num : nums) {
            long cur = num;
            while (!st.isEmpty() && gcd(st.peek(), cur) > 1) {
                cur = lcm(st.pop(), cur);
            }
            st.push(cur);
        }

        List<Integer> ans = new ArrayList<>();
        for (long val : st) ans.add((int) val);
        return ans;
    }
}