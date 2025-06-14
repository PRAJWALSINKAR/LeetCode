class Solution {
    public int minAddToMakeValid(String s) {
        int count=0;
        int close =0;
        for(int i= 0;i<s.length() ;i++){
            if(s.charAt(i) == '('){
                count++;
            }else{
                count--;
            }
            if(count == -1){
                count = 0;
                close--;
            }
        }
        return Math.abs(-close + count);
    }
}