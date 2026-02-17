class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
  
        for(int i = 0 ; i< 12 ; i++ ){
            for(int j = 0 ; j< 60 ; j++){
                int hbit = countBit(i);
                int mbit = countBit(j);
                if(hbit + mbit == turnedOn){
                    if(j< 10){
                        ans.add(i +":0"+j );
                    }else{
                        ans.add(i+":"+j);
                    }
                }
            }
        }
        return ans;
    }

    public int countBit(int n) {
        int bit = 0;
        while (n > 0) {
            bit += n & 1;
            n = n >> 1;
        }
        return bit;
    }
}