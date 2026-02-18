class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean check = true;
        if((n & 1) == 1){
            check = false;
        }
        n = n >> 1;

        while(n > 0){
            if(((n & 1) == 0) && (check == true))return false;
            if(((n & 1) == 1) && (check == false))return false;

            n = n >> 1;
            if(check){
                check = false;
            }else{
                check = true;
            }
        }
        return true;
    }
}