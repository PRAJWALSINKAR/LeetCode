class Solution {
    public int[] getNoZeroIntegers(int n) {
        int [] ans =new int[2];
      
        for(int i = 1 ; i<= n/2 ; i++ ){

            int a = i;
            int b = n-i;
            if(cheak(a) && cheak(b)){
                ans[0] =a;
                ans[1] =b;
                break;
            }
        }
        return ans;
    }
    public static boolean cheak(int val){
        while(val > 0){
            int bit = val % 10 ;
            if(bit == 0)return false;
            val = val / 10;
        }
        return true;
    } 
}