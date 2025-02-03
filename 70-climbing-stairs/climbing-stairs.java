class Solution {
    public int climbStairs(int n) {
         int [] arr = new int [n+1];
         for(int i = 0 ;i<= n ;i++){
            arr[i] = -1;
         }
         return dp(arr, n );
    }
    public static int dp(int [] arr , int n ){
        if(n==1)return 1;
        if(n==2) return 2;

        if(arr[n] != -1) return arr[n];

        arr[n] = dp(arr , n-1) + dp(arr , n-2); //3 = 2 + 1
        return arr[n];
    }
}