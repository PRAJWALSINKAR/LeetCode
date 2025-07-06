class Solution {
    public int countGoodNumbers(long n) {
        int MOD = 1000000007;
        long evenCount = (n+1)/2;
        long oddCount = n/2;
        long evenNo = pow( 5 , evenCount);
        long oddNo = pow(4 , oddCount);
        return (int)((evenNo * oddNo) %MOD);
    }

    public long pow(long val , long n ){
      int MOD = 1000000007;
      long result = 1;
        while(n > 0){
            if(n % 2 == 1){
                result = (result * val) % MOD;
            }
            val =( val * val )%MOD;
            n = n /2;
        }
        return result ;
    }
}