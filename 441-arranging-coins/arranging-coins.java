class Solution {
    public int arrangeCoins(int n) {
        int rem = n;
        int count = 0;
        for(int i = 1 ; i <= n ; i++){
            if(rem - i < 0 )return count;
            count++;
            rem = rem -i;
        }
        return 1;
    }
}