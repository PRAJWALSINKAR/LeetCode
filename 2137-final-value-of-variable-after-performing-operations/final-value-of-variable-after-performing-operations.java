class Solution {
    public int finalValueAfterOperations(String[] s) {
        int ans = 0;
        for (String i : s) {
            if (i.contains("+"))
                ans++;
            else
                ans--;
        }
        return ans;
    }
}