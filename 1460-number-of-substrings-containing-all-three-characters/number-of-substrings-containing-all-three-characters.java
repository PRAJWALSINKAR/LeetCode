class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0; 
        int i =0;
        int j= 0;
        int[]  arr = new int[3]; 
        while(j < n){
            arr[s.charAt(j) - 'a']++;
            while(arr[0] >=1 && arr[1] >= 1 && arr[2] >=1){
                ans += n- j;
                arr[s.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }
        return ans;
    }
}