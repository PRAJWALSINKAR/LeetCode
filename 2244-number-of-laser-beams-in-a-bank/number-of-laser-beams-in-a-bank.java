class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0 ;
        int count =0;

        for(String row : bank){
            int curr = 0;
            for(int i = 0 ; i< row.length() ; i++ ){
                if(row.charAt(i) == '1')curr++;
            }

            count += curr*prev;

            if(curr > 0){
                prev = curr;
            }
        }
        return count;
    }
}