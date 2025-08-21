class Solution {
    public int climbStairs(int n) {
     if(n==1)return 1;
     int prev = 1;
     int justprev = 2;
    
    for(int i = 3 ; i<=n ; i++){
        int temp = prev + justprev;
        prev = justprev;
        justprev = temp;
        
    }
      return justprev;

    } 
}

