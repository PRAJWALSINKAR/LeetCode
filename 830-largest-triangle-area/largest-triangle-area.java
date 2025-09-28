class Solution {
    public double largestTriangleArea(int[][] arr) {
        
        int n = arr.length;
        double max = 0;
        for(int i =0 ;i< n-2 ;i++){
            for(int j =i+1 ; j<n-1 ;j++){
                for(int k = j+1 ; k < n ;k++){
                    ////Area = (1/2) * |x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)|
                    double Area = 0.5 *Math.abs((arr[i][0] *(arr[j][1] - arr[k][1])
                                      + arr[j][0]* (arr[k][1]-arr[i][1]) 
                                        + arr[k][0] *(arr[i][1] - arr[j][1])));

                    max = Math.max(max, Area);
                }
            }
        }
        return max;
    }
}