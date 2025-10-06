class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int low = 0;
        int high = n-1;
        while(low <= high){

            int col = low + (high-low) / 2;
            int  index = 0;
            //max element in particular col 
            for(int row = 0 ; row < m; row++){
                if(mat[row][col] > mat[index][col]){
                    index = row;
                }
            }

            int peak = mat[index][col];
            int rightVal = -1;
            int leftVal = -1;
            if(col > 0)leftVal = mat[index][col-1];
            if(col < n-1)rightVal = mat[index][col+1];
            //it is greater in col so indirectly greater than up and down
            if(peak > leftVal && peak > rightVal){
                return new int[]{index , col};
            }
            //if in right side greater element present then move to right 
            if(peak < rightVal){
                low = col+1;
            }else{
                high = col -1;
            }
        }
        return new int[]{-1,-1};
    }
}