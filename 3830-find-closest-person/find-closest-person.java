class Solution {
    public int findClosest(int x, int y, int z) {
        int first = Math.abs(x-z);
        int sec = Math.abs(y-z);

        if(first < sec)return 1;
        if(sec < first)return 2;

        return 0;
    }
}