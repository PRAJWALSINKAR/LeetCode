class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character , Character> map = new HashMap<>();
        Map<Character , Character> maprev = new HashMap<>();
        int n = s.length();
        for(int i =0 ; i< n ; i++){
            char ch = s.charAt(i);
            char ch2 = t.charAt(i);
            if(map.containsKey(ch)){
               if(map.get(ch) != ch2){
                 return false;
               }
            }
            if(maprev.containsKey(ch2)){
               if(maprev.get(ch2) != ch){
                 return false;
               }
            }
            map.put(ch , ch2);
            maprev.put(ch2 ,ch);
        }
        return true;
    }
}