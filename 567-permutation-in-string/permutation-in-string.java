class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] arr = s1.toCharArray();
        Arrays.sort(arr);
        s1 = new String(arr);
        int n = s1.length();
        for(int i = 0 ; i +n<= s2.length() ; i++){
            char [] s = s2.substring(i , i+n).toCharArray();
            Arrays.sort(s);
            String ss = new String(s);

            if(ss.equals(s1))return true;
        }
        return false;
    }
}