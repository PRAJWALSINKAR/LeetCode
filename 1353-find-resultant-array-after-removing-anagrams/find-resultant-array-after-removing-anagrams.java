class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        char [] s = words[0].toCharArray();
        Arrays.sort(s);
        String prev = new String(s);
        for(int i = 1 ; i< words.length ; i++){
            char [] st = words[i].toCharArray();
            Arrays.sort(st);
            String curr = new String(st);
            if(prev.equals(curr)){
                continue;
            }else{
                ans.add(words[i]);
                prev = curr;
            }
        }
        return ans;
    }
}