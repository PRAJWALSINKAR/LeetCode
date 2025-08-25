class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
      int m=mat.length;
        int n=mat[0].length;
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        int[] ans=new int[m*n];
        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
                                     
            ArrayList<Integer> list = map.getOrDefault(i + j, new ArrayList<>());
            list.add(mat[i][j]);
            map.put(i + j, list);

           } 
        }
        int maxSumDiag=((m-1)+(n-1));
        int idx=0;
        for(int i=0;i<=maxSumDiag;i++){
            if(i%2==0){
               ArrayList<Integer> list=map.get(i);
               Collections.reverse(list);
               for(int num:list){
                    ans[idx++]=num;
                }
            }
            else{
                ArrayList<Integer> list=map.get(i);
                for(int num:list){
                    ans[idx++]=num;
                }
            }
        }
        return ans;    
    }
}