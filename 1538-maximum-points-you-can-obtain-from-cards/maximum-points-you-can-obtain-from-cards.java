class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left = 0;
        int right=cardPoints.length-1;
        int lsum = 0;
        int rsum = 0;
        int max = 0;
        for( left = 0;left <= k-1 ;left++){
            max += cardPoints[left];
        }
        left--;
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