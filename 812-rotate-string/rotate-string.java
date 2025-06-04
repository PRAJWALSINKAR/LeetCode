class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if (n != goal.length()) return false;
          for (int i = 0; i < n; i++){
            boolean present = true;
            for (int j = 0; j < n; j++) {
                if (s.charAt((i + j) % n) != goal.charAt(j)) {
                    present = false;
                    break;
                }
            }
            if (present) return true;
        }

        return false;
    }
}
