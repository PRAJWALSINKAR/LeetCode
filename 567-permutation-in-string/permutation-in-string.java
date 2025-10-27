class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n >m )return false;
        int [] arr = new int[26];
        for(int i = 0 ; i<n ; i++ ){
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }
        if(check(arr))return true;

        for(int i = n ; i < m ; i++ ){
            arr[s2.charAt(i)-'a']--;
            arr[s2.charAt(i-n)-'a']++;
            if(check(arr))return true;
        }
        return false;
    }
    public boolean check(int [] arr){
        for(int i : arr){
            if(i != 0)return false;
        }
        return true;
    }
}