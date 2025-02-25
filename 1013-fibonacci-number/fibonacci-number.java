class Solution {
    public int fib(int n) {
        if(n < 2)return n;
    int first =0 ;
      int secound  = 1;
      int current =0;
     for(int i = 1 ; i<n ; i++){
        current = first + secound;
        first = secound;
        secound = current;
     }
     return current;
    }
}