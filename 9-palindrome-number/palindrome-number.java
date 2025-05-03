class Solution {
    public boolean isPalindrome(int x) {
      if(x < 0 || (x != 0 && x%10 == 0)) return false;
        int num = x;
        int rev = 0;
        while (x > rev) {
            int n = x % 10;
            rev = (rev * 10) + n;
            x = x / 10;
        }
       if(x==rev || x == rev/10)return true;
        return false;
    }
}