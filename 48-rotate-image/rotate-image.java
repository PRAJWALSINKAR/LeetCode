class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // step 1 : firt we swap like(1,2) to (2 , 1)
        // step 2 : just reverse the every rows
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
/*
Time comlixity :- O(n²)  - each element once

Space complixity:- O(1)

*/