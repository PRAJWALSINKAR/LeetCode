class Solution {
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> lis = new ArrayList<>();
        int len = cuts.length;
        for(int i : cuts)lis.add(i);

        lis.add(0);
        lis.add(n);
        Collections.sort(lis);

        int dp[][] = new int[len+1][len+1];

        for(int [] ar : dp){
            Arrays.fill(ar , -1);
        }
        return helper(1,len , lis , dp);
    }
    public static int helper(int i , int j ,ArrayList<Integer> lis, int[][]dp ){
        if(i > j)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int ind=i ; ind<= j ;ind++){
            int temp = lis.get(j+1)-lis.get(i-1)+helper(i, ind-1, lis, dp)+helper(ind+1, j , lis,dp);
            min =Math.min(min,temp);
        }
        return dp[i][j] = min;
    }
}