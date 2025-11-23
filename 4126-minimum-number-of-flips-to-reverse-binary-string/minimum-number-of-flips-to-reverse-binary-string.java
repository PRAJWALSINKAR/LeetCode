class Solution {
    public int minimumFlips(int n) {
         String s = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != s1.charAt(i)) count++;
        }
        return count;
    }
}