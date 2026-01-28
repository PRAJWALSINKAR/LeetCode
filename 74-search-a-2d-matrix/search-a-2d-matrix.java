class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int m = arr.length;
        int n = arr[0].length;
        int left = 0;
        int right = m*n-1;

        while(left <= right ){
            int mid = (left +right ) / 2 ;
            int row = mid / n;
            int col = mid % n ;

            if(arr[row][col] == target)return true;
            else if(target > arr[row][col])left =  mid +1;
            else right = mid -1;
        }
        return false;
    }
}