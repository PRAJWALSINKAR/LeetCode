class Solution {
    public String sortVowels(String s) {
         List<Character> lis = new ArrayList<>(); 
         String vowel =  "aeiouAEIOU";
        for(int i = 0 ; i < s.length() ; i++){
          char t = s.charAt(i);
          if(t=='a' || t =='e' || t =='i' || t=='o' || t =='u'|| t=='A' || t =='E' || t =='I' || t=='O' || t =='U'){
            lis.add(t);
          }
        }
        Collections.sort(lis);

        StringBuilder sb = new StringBuilder();
        int k =0;
        for(int i = 0 ; i< s.length() ; i++){
            char ch = s.charAt(i);
            if(vowel.indexOf(ch) != -1){
                sb.append(lis.get(k++));
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}