class Solution {
    public char findTheDifference(String s, String t) {
        int [] arr = new int[26];
        int n = s.length();
        arr[t.charAt(n)-'a']--;
        for(int i = 0 ; i< s.length() ; i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int i = 0 ; i< 26 ; i++){
            if(arr[i] != 0){
                return (char)(i+97);
            }
        }
        return '0';
    }
}