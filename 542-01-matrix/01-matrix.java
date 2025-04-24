class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        boolean visited[][] = new boolean[rows][cols];
        int[][] result = new int[rows][cols];

        Queue<Pair<Integer,Integer>> que = new LinkedList<>();

        for(int i = 0;i< rows;i++){
            for( int j = 0; j< cols;j++){
                if(mat[i][j] == 0){
                    que.add(new Pair<>(i,j));
                    result[i][j] = 0;
                }
            }
        }

        int [] rowd = { -1, 0, 1, 0 };
        int [] cold = {0 , 1, 0, -1};
        int distance = 0;
        while(!que.isEmpty()){
            ++distance;
            int size = que.size();
            for(int start =0;start < size;start++){
                int r = que.peek().getKey();
                int c = que.peek().getValue();
                int i = 0;
                visited[r][c] = true;//  if we only mark  here instead of 2nd condition  it is not working ,why?
                que.remove();
                while( i < 4){
                    int row = rowd[i] + r;
                    int col = cold[i] + c;
                    if(row >= 0 && col >= 0 && row < rows && col < cols && !visited[row][col] && mat[row][col] == 1){
                            que.add(new Pair<>(row,col));
                            result[row][col] = distance;
                            visited[row][col] = true;     // 2nd condition
                    }
                    i++;
                }
            }
        }
        return result;
    }
}