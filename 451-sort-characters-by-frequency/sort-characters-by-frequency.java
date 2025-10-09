class Solution {
    public String frequencySort(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        int max = 0;
        for(int i= 0 ; i< s.length() ; i++){
            char ch = s.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0) +1);
            if(map.get(ch) > max){
                max = map.get(ch);
            }
        }
        List<List<Character>> lis = new ArrayList<>();

        for(int i = 0 ; i <= max ; i++){
            lis.add(new ArrayList<>());
        }

        for(Map.Entry<Character , Integer> entry : map.entrySet()){
            char key = entry.getKey();
            int val = entry.getValue();

            lis.get(val).add(key);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = max ; i>=0 ; i--){
            for(char ch : lis.get(i)){
                for(int j = 0 ; j < i ; j++){
                     sb.append(ch);
                    }
                }
            }
        return sb.toString();
    }
}