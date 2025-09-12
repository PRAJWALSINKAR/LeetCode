class Solution {
    public int minSideJumps(int[] arr) {
        int n = arr.length;
        int [][] dp =new int[n][4];
        for(int ar[] : dp){
            Arrays.fill(ar , -1);
        }
        return helper(0, 2, arr, dp);
    }
    public  int helper(int ind ,int lane , int [] arr, int[][] dp){
        if(ind == arr.length-1)return 0;

        if(dp[ind][lane] != -1)return dp[ind][lane];

        int ans = Integer.MAX_VALUE;
        if(arr[ind+1] != lane ){
            ans = helper(ind+1 , lane , arr, dp);
        }else{
            for(int i=1;i<=3 ;i++){
                if(i != lane && arr[ind] != i ){
                    int jump =1 + helper(ind , i , arr, dp);
                    ans =Math.min(ans , jump);
                }
            }
        }
        return dp[ind][lane]= ans;
    }
}