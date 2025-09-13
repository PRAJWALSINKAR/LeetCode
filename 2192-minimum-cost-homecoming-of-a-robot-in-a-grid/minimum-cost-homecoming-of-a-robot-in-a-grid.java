class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int si = startPos[0];
        int sj = startPos[1];
        int cost =0;
        //below
        while(si < homePos[0]){
            cost += rowCosts[si+1];
            si++;
        }
         //up
        while(si > homePos[0]){
            cost += rowCosts[si-1];
            si--;
        }
        //left 
        while(sj > homePos[1]){
            cost += colCosts[sj-1];
            sj--;
        }
        //right
        while(sj < homePos[1]){
            cost += colCosts[sj+1];
            sj++;
        }
    return cost;
    }
}