class Solution {
    public int countCommas(int n) {
       int ans = 0;
       if(n < 1000)return ans;

       return n - 1000 + 1;
    }
}