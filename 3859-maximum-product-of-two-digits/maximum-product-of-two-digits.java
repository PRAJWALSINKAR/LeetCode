class Solution {
    public int maxProduct(int n) {
        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MIN_VALUE;

        while(n > 0 ){
            int digit = n%10;
            n = n / 10 ; 
            if(digit > num1){
                num2 = num1;
                num1 = digit; 
                continue;
            }
            if(digit > num2){
                num2 = digit;
            }
        }
        return num1  * num2;
    }
}