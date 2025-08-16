class Solution {
    public int orangesRotting(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        Queue<Pair<Integer,Integer>> que = new LinkedList<>();
        int freshOranges = 0;
    
        for(int i =0;i<rowLen;i++){
            for(int j = 0; j< colLen;j++){

                if(grid[i][j] == 2){
                    que.add(new Pair<>(i,j));
                }
                else if(grid[i][j] == 1 ) freshOranges++;
            }
        }

        int minutes= 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!que.isEmpty() && freshOranges >0){
            int size = que.size();
            minutes++;

            for(int i = 0;i<size;i++){
                int r = que.peek().getKey();
                int c = que.peek().getValue();
                que.remove();

                for(int[] direction : directions){
                    int cr = r + direction[0];
                    int cc = c + direction[1];

                    if(cc >= 0 && cc < colLen && cr >= 0 && cr<rowLen && grid[cr][cc] == 1){
                        grid[cr][cc] = 2;
                        freshOranges --;
                        que.add(new Pair<>(cr,cc));
                    }
                }
            }
        }
        return freshOranges ==0 ? minutes:-1;
    }
}