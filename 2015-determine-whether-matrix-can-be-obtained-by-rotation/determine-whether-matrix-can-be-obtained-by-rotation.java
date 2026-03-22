class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            rotate(mat);
            if (campare(mat, target))
                return true;
        }
        return false;
    }

    public void rotate(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;

        for (int i = 0; i < r ; i++){
            for (int j = i ; j < c ;j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for (int i = 0; i < r; i++) {
            int left = 0, right = r - 1;
            while (left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public boolean campare(int arr[][], int tar[][]) {
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != tar[i][j])
                    return false;
            }
        }
        return true;
    }
}