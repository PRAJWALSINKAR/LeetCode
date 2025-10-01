class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int low = 0;
        int n = mat.length;
        int m = mat[0].length;
        int high = (m * n) - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m;
            int col = mid % m;
            if(mat[row][col] == target)
                return true;
            else if (mat[row][col] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}