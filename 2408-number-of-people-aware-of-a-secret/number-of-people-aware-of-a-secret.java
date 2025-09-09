class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int [] dp = new int[n+1];
        int mod = 1000000007;
        dp[1] = 1;
        int currPeople = 0;
        for(int day =2 ; day <=n ; day++){
            if(day - delay >= 1){
                currPeople = (currPeople + dp[day -delay])%mod;
            }
            if(day - forget >= 1){
              currPeople = (currPeople - dp[day -forget]+mod)%mod;
            }
            dp[day] = currPeople;
        } 
        int total = 0 ;
        for(int i = n-forget+1 ; i<=n ;i++){
            total = (total+ dp[i]) %mod;
        }
        return total;
    }
}