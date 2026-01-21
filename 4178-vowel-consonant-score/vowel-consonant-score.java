class Solution {
    public int vowelConsonantScore(String s) {
        int count = 0;
        int constant = 0;
        int n = s.length();
        for(int i = 0 ;i < n ;i++){
            char ch  = s.charAt(i);
            if(ch < 60)continue;
            if(ch == 'a' ||ch == 'o' ||ch == 'i' ||ch == 'e' ||ch == 'u'){
                count++;
            }else{
                constant++;
            }
        }
        if(constant == 0)return 0;
        return count / constant;
    }
}