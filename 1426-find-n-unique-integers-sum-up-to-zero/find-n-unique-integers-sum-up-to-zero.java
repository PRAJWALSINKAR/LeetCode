class Solution {
    public int[] sumZero(int n) {
       int [] ans = new int[n];
       int len = 0;
       if(n % 2 == 1){
        ans[len++] = 0;
        n--;
       }
       if(n==0)return ans;
       int val = 1;
       while(len < n){
       ans[len++] = val;
       ans[len++] = -val;
       val++; 
       }
       return ans;
    }
}