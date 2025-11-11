class Solution {
    int [] even;
    int [] odd;
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        even = new int[len];
        odd = new int[len];

        int [][][] dp = new int[len][m+1][n+1]; 
        for(int i = 0 ;i<len ; i++){
            String s = strs[i];
            int l = s.length();
            int count = 0;
            for(char x : s.toCharArray()){
                if(x == '0')count++;
            }
            even[i] = count;
            odd[i] = l - count;
        }
        return helper(0 , even , odd , m , n , dp);
    }

    public int helper(int ind , int[] even , int [] odd , int m , int n , int[][][] dp ){
        if(ind >= odd.length)return 0;

        int x = m - even[ind];
        int y = n - odd[ind];
        if(dp[ind][m][n] != 0)return dp[ind][m][n];
        int pick = Integer.MIN_VALUE;

        if(x >=0 && y >= 0 ){
            pick = 1 + helper(ind + 1 , even , odd , x , y , dp);
        }

        int nonPick = helper(ind + 1 , even , odd , m , n , dp);

        return dp[ind][m][n] = Math.max(pick , nonPick);
    }
}