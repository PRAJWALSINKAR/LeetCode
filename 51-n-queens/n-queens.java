class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean [] RL = new boolean[n*2+1];
        boolean [] LR = new boolean[n*2+1];
        boolean CL [] = new boolean[n+1]; 
        int [][] arr = new int[n][n];
        helper(0 , ans , arr ,  RL , LR , CL , n );
        return ans;
    }
    public void helper(int row , List<List<String>> ans , int [][] arr ,  boolean [] RL , boolean [] LR, boolean [] CL , int n  ){
        if(row == n){
            ans.add(new ArrayList<>(change(arr)));
            return;
        }
        for(int col = 0 ; col < arr.length ; col++){
            if(check(row , col ,  RL , LR , CL , n )){
                LR[row + col] = true;
                RL[n+ (col - row)] = true;
                CL[col] = true;
                arr[row][col] = 1;
                helper(row + 1 ,  ans , arr , RL , LR , CL , n);

                arr[row][col] =0;
                LR[row + col] = false;
                RL[n+ (col - row)] = false;
                CL[col] = false;

            }
        }
    }
    public boolean check(int row , int col , boolean [] RL , boolean [] LR, boolean [] CL , int n  ){
        if(LR[row + col] == true || RL[n+ (col - row)] == true || CL[col] == true)return false;
        return true;
    }
    public List<String> change(int[][] arr){
        List<String> lis = new ArrayList<>();
        int n = arr.length;
        for(int i = 0 ; i <n ; i++){
            String s = "";
            for(int j = 0 ; j< n ; j++){
                if(arr[i][j] == 0){
                    s =s + ".";
                }else{
                    s= s + 'Q';
                }
            }
            lis.add(s);
        }
        return lis;
    }
}