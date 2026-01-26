class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int [] arr = new int[3];
        int n = s.length();
        int i = 0;
        int j = 0;
        while(j < n){
             arr[s.charAt(j) - 'a']++;
            while(arr[0] > 0 && arr[1] > 0  && arr[2] > 0){
                ans += n - j;
                int val = s.charAt(i) - 'a'; 
                arr[val]--;
                i++;
            }
            j++;
        }
        return ans;
    }
}