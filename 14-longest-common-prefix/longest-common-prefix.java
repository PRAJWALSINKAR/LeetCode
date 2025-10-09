class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n = strs.length;
        String ch1 = strs[0];
        String ch2 = strs[n-1];
        StringBuilder sb = new StringBuilder();
        int n2 =ch1.length();
        int n3 = ch2.length();
        for(int i =0 ; i < Math.min(n2,n3) ; i++){
            if(ch1.charAt(i) == ch2.charAt(i)){
                sb.append(ch1.charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }
}