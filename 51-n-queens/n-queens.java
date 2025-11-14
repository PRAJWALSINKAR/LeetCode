class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int [][] arr = new int[n][n];
        helper(0 , arr , ans);
        return ans;
    }
    public void helper(int row , int [][] arr , List<List<String>> ans ){
        if(row == arr.length){
            ans.add(new ArrayList<>(change(arr)));
            return;
        }
        for(int col = 0 ; col < arr.length ; col++){
            if(check(row , col , arr)){
                arr[row][col] = 1;
                helper(row + 1 , arr , ans);
                arr[row][col] = 0;
            }
        }
    }
    public boolean check(int row , int col , int [][] arr){
        int drow = row;
        int dcol = col;
        //left
        while(row >= 0){
            if(arr[row][col] == 1)return false;
            row--;
        }
        //up-left
        row = drow;
        while(row >= 0  && col >=0){
            if(arr[row][col] == 1 )return false;
            row--;
            col--;
        }
        row = drow;
        col = dcol;
        //up-right
        while(row >= 0 && col < arr.length){
            if(arr[row][col] == 1 )return false;
            row--;
            col++;
        }
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