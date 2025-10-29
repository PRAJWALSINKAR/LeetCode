class Solution {
    public int smallestNumber(int n) {
        for(int i = 1 ; i<= n ; i++){
            int curr = 1 << i;
            if(curr > n)return curr-1;
        }
        return -1;
    }
}