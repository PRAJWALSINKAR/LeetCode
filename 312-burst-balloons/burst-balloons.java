class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][]  =new int[n+2][n+2];

        for(int [] arr: dp){
            Arrays.fill(arr , -1);
        }
        
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(1);
        for(int i : nums)lis.add(i);
        lis.add(1);

        return helper(1,n,lis , dp);
    }
    public static int helper(int i , int j , ArrayList<Integer> lis , int[][]dp){
        if(i > j)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int coin = Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
           int temp = lis.get(j+1)*lis.get(k)*lis.get(i-1) + helper(i , k -1,lis , dp)+helper(k+1,j,lis,dp);
           coin=Math.max(coin , temp);
        }
        return dp[i][j]=coin;
    }
}