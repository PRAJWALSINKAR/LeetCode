class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left = k-1;
        int right=cardPoints.length-1;
        int lsum = 0;
        int rsum = 0;
        int max = 0;
        for( int i = 0;i <= k-1 ;i++){
            max += cardPoints[i];
        }
        lsum = max;
        while(left >= 0){
        lsum -= cardPoints[left];
        rsum += cardPoints[right];
        
       max = Math.max(max , lsum + rsum);
       right--;
       left--;
    }
    return max;
         
    }
}