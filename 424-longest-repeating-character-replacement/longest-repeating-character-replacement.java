class Solution {
    public int characterReplacement(String s, int k) {
    int left= 0;
    int max = 0;
    int n = s.length(); 
    Map< Character , Integer> map = new HashMap<>(); 
    for(int right = 0 ; right < n ; right++){
        map.put(s.charAt(right) , map.getOrDefault(s.charAt(right) , 0)+1);

        while(map.get(s.charAt(left)) + k < right - left + 1){
            map.put(s.charAt(left) , map.getOrDefault(s.charAt(left) , 0)-1);
            left++;
        }

        max = Math.max(right - left +1 , max);
        max = Math.max(max , map.get(s.charAt(right)) + k);
      }
      return max<n?max:n;
    }
}