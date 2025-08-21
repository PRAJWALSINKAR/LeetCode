class Pair {
    int x = 0;
    int y = 0;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols =grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        if(grid[0][0] == 1)return -1;
        int [][] dir = {{-1,-1} , {-1,0}, {0,-1}, {1,1} ,{1,0} ,{0,1}, {-1,1}, {1,-1}};

        q.add(new Pair(0 , 0));
        boolean[][] vis = new boolean[rows][cols];
        int level =0;
        q.add(new Pair(0,0));

       while(!q.isEmpty()){
        ++level;
        int size = q.size();

        for(int i =0 ;i<size;i++){
            Pair curr = q.poll();
            int rowx = curr.x;
            int coly = curr.y;
            vis[rowx][coly] = true;
        
            for(int [] temp : dir){
                int row= temp[0] + rowx;
                int col = temp[1] + coly;
                if(row>= 0 && col >=0 && row < rows && col < cols && grid[row][col] == 0 ){
                    if(!vis[row][col]){
                        q.add(new Pair(row , col));
                        vis[row][col] = true;
                        if(vis[rows-1][cols-1] == true)return level+1;
                    }
                }
            }
        }
       }
       if(vis[rows-1][cols-1] == false)return -1;
       return level;
    }
}