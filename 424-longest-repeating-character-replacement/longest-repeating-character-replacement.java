class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int n = s.length();
        int maxl=0;
        int right = 0;
        int freq = 0;
        HashMap<Character , Integer> map = new HashMap<>();
        while(right < n){
            char x = s.charAt(right);
              map.put(x, map.getOrDefault(x , 0) + 1);
              freq = Math.max(freq , map.get(x));
             
               if((right - left +1) - freq > k){
                while((right - left +1)- freq > k){
                char leftx = s.charAt(left); 
                map.put(leftx , map.get(leftx)-1);
                left++;
                }
               }
            maxl = Math.max(maxl , right - left+1);
            right++;
        }
        return maxl;
    }
}