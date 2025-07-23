class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxl = 0;
        Map<Character , Integer> map = new HashMap<>();
        while(right < n){
            if(map.containsKey(s.charAt(right))){
                while(left < right){
                    if(s.charAt(left) == s.charAt(right)){
                        left++;
                        break;
                    }
                    map.remove(s.charAt(left));
                    left++;
                    }
                }else{
                    map.put(s.charAt(right),0);
                    maxl = Math.max(maxl , right - left + 1);
                }
                right++;
            }
        return maxl;
    }
}