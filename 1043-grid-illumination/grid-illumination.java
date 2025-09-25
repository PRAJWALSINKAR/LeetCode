//add notes for uniqe String set for matrix , rows and col uniqe number
class Solution {
    public int[] gridIllumination(int n, int[][] lamp, int[][] q) {
        int [] ans = new int[q.length];
        Set<String> st = new HashSet<>();
        Map<Integer , Integer > rowm =  new HashMap<>();
        Map<Integer , Integer > colm =  new HashMap<>();
        Map<Integer , Integer > digl =  new HashMap<>();
        Map<Integer , Integer > digr =  new HashMap<>();
        for(int [] arr : lamp){
            int r = arr[0];
            int c = arr[1];
            if(!st.contains(r+" "+c)){
                rowm.put(r , rowm.getOrDefault(r,0)+1);
                colm.put(c , colm.getOrDefault(c,0)+1);
                digl.put(r-c , digl.getOrDefault(r-c,0)+1);
                digr.put(r+c , digr.getOrDefault(r+c,0)+1);
                st.add(r+" "+c);
            }
        }
        int[][] direction = {{0,0},{0,1},{1,0},{1,1},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1}};
        int val = 0;
        for(int [] ar : q){
            int row = ar[0];
            int col = ar[1];
            if(rowm.getOrDefault(row ,0) >0 || colm.getOrDefault(col ,0) >0 || digl.getOrDefault(row-col ,0) >0 || digr.getOrDefault(row+col ,0) > 0){
                ans[val++] = 1; 
            }else{
                ans[val++] =0;
            }
            for(int [] dir : direction){
                int nrow = row + dir[0];
                int ncol = col + dir[1];
                if(st.contains(nrow+" "+ncol)){
                    if(rowm.containsKey(nrow)){
                        rowm.put(nrow , rowm.getOrDefault(nrow , 0) -1);
                    }
                    if(colm.containsKey(ncol)){
                        colm.put(ncol , colm.getOrDefault(ncol , 0) -1);
                    }
                    if(digl.containsKey(nrow - ncol)){
                        digl.put(nrow - ncol, digl.getOrDefault(nrow - ncol , 0) -1);
                    }
                    if(digr.containsKey(nrow + ncol)){
                        digr.put(nrow + ncol , digr.getOrDefault(nrow + ncol , 0) -1);
                    }
                    st.remove(nrow+" "+ncol);
                }
            }
        }
        return ans;
    }
}