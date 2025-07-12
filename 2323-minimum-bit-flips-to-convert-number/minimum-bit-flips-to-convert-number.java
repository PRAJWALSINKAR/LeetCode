class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;

        int xor  = start ^ goal ; // same bit should be convert to 0

        while(xor > 0){

            count += (xor & 1) ;//cheak last is 0 or not (if 1 add it )

            xor = xor >> 1 ; //it used to divide by 2 or it decrase l last digiit to
        }
        return count;
    }
}