//my approch
class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = b.length();
         
        for(int i = 0 ; i< n/a.length() +2 ; i++){ // uses gpt for TLE
            sb.append(a);
            if(sb.toString().contains(b)){
                return i+1;
            }
        }
        return -1;
    }
}
/*
Time Complexity: O(n × (n + m)) due to repeated substring checks inside the growing string;
Space Complexity: O(n + m) for storing the repeated string and conversion to a string during checks.
*/