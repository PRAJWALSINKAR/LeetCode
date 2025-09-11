class Solution {
    public String reverseVowels(String s) {
        String vowel = "aeiouAEIOU";
        List<Character> lis   = new ArrayList<>();
        for(int i =0 ; i<s.length() ;i++){
            char ch = s.charAt(i);
            if(vowel.indexOf(ch) != -1 ){
                lis.add(ch);
            }
        }
        Collections.reverse(lis); 
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for(int i =0 ;i < s.length() ;i++){
           char ch = s.charAt(i);
           if(vowel.indexOf(ch) == -1){
            sb.append(ch);
           }else{
            sb.append(lis.get(k++));
           }
        }
        return sb.toString();
    }
}