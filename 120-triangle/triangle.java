class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int [] dp = new int[m];

        for(int i = 0 ; i< m; i++){
            dp[i] = triangle.get(m-1).get(i);
        }

        for(int i = m-2 ; i >=0;i--){
            for(int j = 0 ; j<=i ; j++){
                int bottom = dp[j];
                int bottomLeft = dp[j+1];

                dp[j] = Math.min(bottom , bottomLeft) + triangle.get(i).get(j);
             }
        }
        return dp[0];
    }
}