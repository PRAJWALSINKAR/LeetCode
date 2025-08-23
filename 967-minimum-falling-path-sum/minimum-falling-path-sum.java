class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int [] prev = matrix[0].clone();
       

        for(int i = 1 ; i < m ; i++){
             int [] curr =  new int[n];
            for(int j = 0 ; j< n ; j++){
                int up = prev[j];
                int upleft =Integer.MAX_VALUE;
                int upright =Integer.MAX_VALUE;

                if(j > 0){
                     upleft = prev[j-1];
                }
                if(j<n-1){
                     upright = prev[j+1];
                }
                curr[j]= matrix[i][j] + Math.min(up, Math.min(upleft , upright));
            }
            prev = curr;
        }
        int ans = Integer.MAX_VALUE;
        for(int i =0; i< n ; i++){
            ans = Math.min(ans , prev[i]);
        }
        return ans;
    }
}