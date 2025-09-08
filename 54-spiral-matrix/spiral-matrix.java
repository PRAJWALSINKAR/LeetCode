class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0;
        int right = m-1;
        int bottom = n-1;
        int left =0;
        List<Integer> ans = new ArrayList<>();
        while(left <= right && top <= bottom ){
            //left to right by top
            for(int i = left ;i<= right ; i++ ){
                ans.add(matrix[top][i]);
            }
            top++;
            //top to bottom by right
            for(int i =top ; i<=bottom ; i++){
                ans.add(matrix[i][right]);
            }
            right--;
            if(top > bottom)break;
            //right to left by bottom
            for(int i = right ; i >= left ; i--){
            
                ans.add(matrix[bottom][i]);
            }
            bottom--;
              
            if(left > right)break;
            //bottom to top by left
            for(int i = bottom ; i>=top ; i--){
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}