class Solution {
    public String longestCommonPrefix(String[] strs) {

        // eazy approch
        if(strs.length == 0)return "";

        for(int i = 0 ; i< strs[0].length() ; i++){
            char ch = strs[0].charAt(i);
            for(int j = 1;j< strs.length ; j++){
                if( strs[j].length() <= i ||strs[j].charAt(i) != ch ){
                  return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}

/*
time = O(S)==> S-> number of string in array 
Space = O(1)
*/