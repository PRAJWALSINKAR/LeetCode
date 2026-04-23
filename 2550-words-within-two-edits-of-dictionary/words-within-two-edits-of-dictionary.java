class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for(String s : queries){
            if(match(s ,dictionary )){
                ans.add(s);
            }
        }
        return ans;
    }
    public static boolean match(String s , String [] arr){
        for(String  str : arr){
            int count = 0;
            for(int i = 0 ; i < s.length() ; i++){
                if(s.charAt(i) != str.charAt(i)){
                    count++;
                }
                if(count > 2)break;
            }
            if(count <= 2)return true;
        }
        return false;
    }
}