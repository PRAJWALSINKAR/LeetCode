class Solution {
    public int minimumPushes(String word) {
      int ans =0;
      int mul = 1;
      int n = word.length();
      int multi =0;

      while(n >= 8){
        ans += mul * 8;
        n = n-8 ;
        mul++;
      }
      if(n > 0){
        ans += mul * n;
      }
      return ans;
    }
}