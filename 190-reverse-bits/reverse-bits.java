class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        int count = 32;

        while(count-- > 0){
            int bit = n & 1;
            n = n >> 1;
            ans = ans << 1;
            ans = ans | bit;
        }
        return ans;
    }
}