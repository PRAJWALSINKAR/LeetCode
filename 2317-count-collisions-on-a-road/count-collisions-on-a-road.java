class Solution {
    public int countCollisions(String dir) {
        int ans = 0;
        int left = 0;
        boolean sti = false;
        int right = 0;
        int count = 0;
        int n = dir.length();
        for (int i = 0; i < n; i++) {
            char ch = dir.charAt(i);

            if (ch == 'R') {
                right++;
            } else if (ch == 'L') {
                if (right != 0) {
                    ans += 2;
                    right--;
                    sti = true;
                    count = right;
                    continue;
                }
                if (sti) {
                    ans++;
                }
            } else {
                sti = true;
                if (right != 0) {
                    ans += right;
                    right = 0;
                    count =0;
                }
            }
        }
        
        return ans + count;
    }
}