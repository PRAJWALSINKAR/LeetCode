class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character , Integer> map = new HashMap<>();
        int left =0;
        int max =0;
        for(int right  = 0 ; right< s.length() ; right++){
             char ch = s.charAt(right);
            while(map.containsKey(ch)){
                map.remove(s.charAt(left));
                left++;
            }
            map.put(ch , 1);
            max = Math.max(right - left +1 , max);
        }
        return max;
    }
}