class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int[n][n];

        for(int j = 0;j < n;j++){     // step 1 :- base condition (last row same)
            dp[n-1][j] = triangle.get(n-1).get(j); 
        }
       // step 2 :- we find out every point minimum value
        for(int i = n-2; i >= 0 ; i--){   // last 2nd row -> last col -> TO-> last 2nd row -> 0 col
            for(int j = i ; j>=0 ; j-- ){   // last 2nd row(ex 3 row -> the elemeant in that is also 3 )
                int down = triangle.get(i).get(j) + dp[i+1][j]; 
                int downleft = triangle.get(i).get(j) + dp[i+1][j+1];
               
               dp[i][j] = Math.min(down , downleft); 

            }
        }
        return dp[0][0];
    }
}