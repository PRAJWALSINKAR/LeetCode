class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        int Mlen = 0;
        int Clen = 0;

        while(j < nums.length){
            if(nums[j]==0){
                count++;
            }
            while(count > k){//0>
             if(nums[i] == 0){
                count--;
             }
            i++;
        }
         Mlen = Math.max(Mlen, j - i + 1);
         j++;
    }
    return Mlen;
    }
}