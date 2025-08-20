class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Pair> que = new LinkedList<>();
        boolean[][] vis = new boolean[rows][cols];
        int [][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        if(grid[0][0]  != 0)return -1;
        que.add(new Pair(0,0));
        int level = 0;
        while(!que.isEmpty()){
            ++level;
            int size = que.size();

            for(int o = 0;o< size;o++){
                Pair cur = que.poll();
                int i = cur.x;
                int j = cur.y;
                vis[i][j] = true;

                for(int [] temp : dir){
                    int row = i+temp[0];
                    int col = j+temp[1];
                    if(row >= 0 && col >= 0 && row < rows && col < cols && vis[row][col] == false && grid[row][col] == 0){
                        que.add(new Pair(row,col));
                        vis[row][col] = true;
                        if(vis[rows-1][cols-1] == true){
                            return level+1;
                        }
                    }
                }  
            }

        }

        if(vis[rows-1][cols-1]== false) return -1;
        return level;
    }
}


class Pair{
    int x;
    int y;
    
    Pair(int x,int y){
        this.x = x;
        this.y= y;
    }
}