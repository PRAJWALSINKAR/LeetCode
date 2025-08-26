class Solution {
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int [][] dp =new int[n][amount+1];
        for(int [] arr : dp){
            Arrays.fill(arr , -1);
        }
        return helper(0 , 0 , amount , coins , dp);
    }
    public static int helper(int ind , int currSum , int target , int [] arr , int [][] dp){
        if(ind == arr.length){
            if(currSum == target){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[ind][currSum] != -1 )return dp[ind][currSum];

        int nontake = helper(ind +1 , currSum , target , arr , dp);
        int take =0 ;
        if(currSum + arr[ind] <= target){
            take = helper(ind  , currSum + arr[ind] , target , arr , dp);
        }
        dp[ind][currSum] = take + nontake;

        return dp[ind][currSum];
    }
}