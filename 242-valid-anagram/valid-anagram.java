class Solution {
    public boolean isAnagram(String s, String t) {
       int n =s.length();
       if(n != t.length()) return false;
        int [] arr= new int[30];
        for(int i = 0 ;i< n ;i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int i = 0 ;i< 30 ; i++){
            if(arr[i] > 0)return false;
        }
        return true;
    }
}

/*
time complixity = O(N)
space complixity = O(1)
*/