class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(0,s,res , temp);
        return res;
    }
    public void backtrack(int ind , String s , List<List<String>> res , List<String> temp){
        if(ind  == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = ind ; i<s.length();i++){
             if(ispalindrom(s,ind , i)){
            temp.add(s.substring(ind , i+1));// aabc
            backtrack(i +1,s,res , temp);
            temp.remove(temp.size()-1);
            }    
        }

    }
    public boolean ispalindrom(String s  , int start  , int end){
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
         return true;
    }
}