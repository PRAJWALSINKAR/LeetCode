class Solution {
    public String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        Arrays.sort(strs);
        int n = strs[0].length();
        String w1 = strs[0];
        String w2 = strs[size - 1];
        int count = 0 ;
        for(int i= 0 ;i < n ; i++){
           if(w1.charAt(i) == w2.charAt(i)){
            count++;
           }else{
            return w1.substring(0, count);
           }
        }
        return w1;
    }
}