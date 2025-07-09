class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(0, s, res, temp);
        return res;
    }

    public void helper(int idx , String s , List<List<String>> res , List<String> temp){
        if(idx == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = idx ; i< s.length() ; i++){
        if(isPalindrom(s , idx , i)){
            temp.add(s.substring(idx ,i+1 ));
            helper(i+1 , s , res , temp);  //imp
            temp.remove(temp.size() -1 );
        }
    }
}

    public boolean isPalindrom(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}