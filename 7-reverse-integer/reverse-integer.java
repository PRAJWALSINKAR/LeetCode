class Solution {
    public int reverse(int x) {
        long ans = 0;
        int num =  x;
        if(x < 0){
            x = x * -1;
        }

        while (x > 0) {
            int n = x % 10;
            ans = (ans * 10) + n;
            x = x / 10;
        }
        if( ans > Integer.MAX_VALUE  || ans < Integer.MIN_VALUE){
            return 0;
        }
        if (num < 0) {
            return  (int)ans * -1;
        }
        return (int) ans;
    }
}