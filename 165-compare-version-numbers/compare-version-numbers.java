class Solution {
    public int compareVersion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int i =0;
        int j =0;
        while(i < n || j < m){
            int num1 =0;
            int num2 = 0;
            while(i < n && s1.charAt(i) != '.' ){
                num1 = num1 * 10 + s1.charAt(i) -'0';
                i++; 
            }
            while(j < m && s2.charAt(j) != '.' ){
                num2 = num2 * 10 + s2.charAt(j) -'0';
                j++; 
            }
            if(num1 < num2)return -1;
            if(num1 > num2)return 1;
            i++;
            j++;
        }
        return 0;
    }
}