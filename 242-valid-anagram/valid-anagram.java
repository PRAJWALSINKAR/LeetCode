class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m != n)return false;
        int [] arr = new int[26];

        for(int i = 0; i< m ; i++){
            arr[s.charAt(i)- 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for(int i :arr){
            if(i != 0)return false;
        }
        return true;
    }
}