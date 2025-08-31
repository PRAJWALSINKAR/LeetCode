class Solution {
    public int longestStrChain(String[] arr) {
        int n = arr.length;
        int [] dp = new int[n];
        Arrays.fill(dp , 1);
        
        Arrays.sort(arr , (a,b) -> a.length() - b.length());
        int max =0;

        for(int i =0 ; i < n ; i++){
            for(int j =0 ; j<i ;j++){
                if(campare(arr[i] ,arr[j]) && dp[i] < dp[j] +1 ){
                    dp[i] =dp[j] + 1;      
                }
            }
            max = Math.max(dp[i] , max);
        }
      return max;
    }

    public boolean campare(String s1 , String s2){
        if(s1.length() != s2.length() +1)return false;

        int first =0;
        int secound =0;

        while(first < s1.length() ){
            if(secound < s2.length() && s1.charAt(first) == s2.charAt(secound)){
                first++;
                secound++;
            }else{
                first++;
            }
        }
         if(first == s1.length() && secound == s2.length())return true;
        return false;

    }
}