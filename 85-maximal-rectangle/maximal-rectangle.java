class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int [][] sumarr = new int[row][col];
        int max =0;

        for(int i =  0; i< col ;i++ ){
            int sum = 0;
            for(int j = 0 ; j<row ; j++ ){
                if(matrix[j][i] == '0'){
                    sum= 0;
                }else{
                    sum += 1;
                }
                sumarr[j][i] = sum;
            }
        }

        for(int i =0 ; i< row ; i++){
            max  = Math.max(max , findLargest(sumarr[i]));//we send sumarr row
        }
        return max;
    }

    public int findLargest(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int n = heights.length;
        int element = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int next = n;
            int prev = -1;
            while (!stk.isEmpty() && heights[i] < heights[stk.peek()]) {
                next = i;
                element = heights[stk.pop()];
                if (!stk.isEmpty()) {
                    prev = stk.peek();
                } else {
                    prev = -1;
                }
                max = Math.max(max, element * (next - prev - 1));
            }
            stk.push(i);
        }
        while (!stk.isEmpty()) {
            int next = n;
            int prev = -1;
            element = heights[stk.pop()];
            if (!stk.isEmpty()) {
                prev = stk.peek();
            } else {
                prev = -1;
            }
            max = Math.max(max, element * (next - prev - 1));
        }
        return max;
    }
}