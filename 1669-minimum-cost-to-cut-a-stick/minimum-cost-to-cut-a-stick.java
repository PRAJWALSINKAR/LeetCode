class Solution {
    public int minCost(int n, int[] cuts) {
        int  len = cuts.length;

        ArrayList<Integer> lis = new ArrayList<>();

        for(int z : cuts)lis.add(z);

        lis.add(0);
        lis.add(n);
        Collections.sort(lis);

        int dp[][] = new int[len+2][len+2];
 
        for(int [] arr : dp){
            Arrays.fill(arr , -1);
        }
        return helper(1 ,len , lis , dp );
    }
    public int helper(int i , int j ,ArrayList<Integer> lis , int[][]dp ){
        if(i > j)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = lis.get(j + 1) - lis.get(i - 1) +
                       helper(i, ind - 1, lis, dp) +
                       helper(ind + 1, j, lis, dp);

            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }
}