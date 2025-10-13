class Solution {
    public int beautySum(String s) {
       int sum = 0;
       int n = s.length();
       for(int i = 0 ; i < n ; i++){
            int [] arr = new int[26];
            arr[s.charAt(i) - 'a']++;
            for(int j = i+1 ; j < n ;j++){
                arr[s.charAt(j) - 'a']++;

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                for(int freq : arr){
                    if(freq  > 0){
                        max = Math.max(max ,freq);
                        min = Math.min(min ,freq);
                    }
                }
                sum += (max - min);
            }
        }
        return sum; 
    }
}