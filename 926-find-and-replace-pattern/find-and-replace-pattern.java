class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> lis = new ArrayList<>();
        for(String s : words){
            if(cheak(s , pattern)){
                lis.add(s);
            }
        }
        return lis;
    }
    public boolean cheak(String s , String t){
        if(s.length() != t.length())return false;

        for(int i =0 ; i<s.length() ; i++ ){
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i)))return false;
        }
        return true;
    }
}