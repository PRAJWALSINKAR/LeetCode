class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long p = n ;
        if(n<0){
        p = -(p);
        }
        if(n < 0){
        return 1/helper(x , p , ans);
        }
        return  helper(x , p , ans);

    }
        public static  double helper(double x , long p , double ans){
           if(p == 0 )return ans;
            if(p % 2 == 1){
              ans = ans*x;
              p = p -1;
            }
            else{
                x = x*x;
                p = p /2;
            }
        return helper(x,p,ans);
        }
    }