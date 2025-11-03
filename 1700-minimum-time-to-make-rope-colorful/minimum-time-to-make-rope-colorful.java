class Solution {
    public int minCost(String s, int[] arr) {
        int ans = 0;
        int n = arr.length;
        for(int i = 1 ; i < n ;i++ ){
            int max = 0;
            while(i < n && s.charAt(i) == s.charAt(i-1)){
                ans += arr[i-1];
                max = Math.max(max , arr[i-1]);
                i++;
            }
            ans += arr[i-1];
            max = Math.max(max , arr[i-1]);
            ans -= max;
        }
        return ans;
    }
}