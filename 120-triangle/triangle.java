class Solution {
    public int minimumTotal(List<List<Integer>> arr) {
        int n = arr.size();
        int[] prev = new int[n];
        int []curr = new int [n];
         
        prev[0] = arr.get(0).get(0);

        for(int i =1 ; i< n ;i++){
            for(int j =0 ;j<arr.get(i).size() ; j++ ){
                int up = Integer.MAX_VALUE;
                int upLeft = Integer.MAX_VALUE;
                if(j < arr.get(i).size() -1 ) {
                    up = prev[j];
                }
                if( j> 0 ){
                    upLeft = prev[j-1];
                }
                curr[j] =  Math.min(up , upLeft) + arr.get(i).get(j);
            }
            prev = curr.clone();
        }
        int ans =Integer.MAX_VALUE;
        for(int i : prev){
           ans = Math.min(i , ans);
        }
        return ans;
    }
}