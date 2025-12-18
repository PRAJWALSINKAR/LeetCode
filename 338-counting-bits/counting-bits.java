class Solution {
    public int[] countBits(int n) {
        int ans [] = new int[n+1];

        for(int i = 1 ; i<= n ; i++){
            int count = countb(i);
            ans[i] = count;
        }
        return ans;
    }
    public int countb(int n ){

        int count = 0;
        while(n > 0){
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }
}