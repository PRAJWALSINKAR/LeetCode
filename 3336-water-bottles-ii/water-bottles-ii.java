class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int fullBottles = numBottles;
        int empty = numBottles;

        while(empty >= numExchange){
           empty  = empty - numExchange;
           fullBottles++;
           numExchange++;
           empty++;
        }
        return fullBottles;
    }
}