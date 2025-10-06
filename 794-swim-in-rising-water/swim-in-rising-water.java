class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int res = 0;
        boolean [][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0] );
        pq.add(new int[] {grid[0][0] , 0 , 0});
        vis[0][0]=true;
        int [][] direction = {{0,1} , {1,0} , {-1 , 0 }, {0,-1}};
        
        while(!pq.isEmpty()){
            int [] arr = pq.poll();
            int row = arr[1];
            int col = arr[2];
            res = Math.max(res, arr[0]);
            if(row == n-1 && col == n-1 )break;

            for(int dir[] : direction){
                int xx = row + dir[0];
                int yy = col + dir[1];
                if(xx >= 0 && yy >= 0 && xx < n && yy < n && vis[xx][yy]==false){
                pq.add(new int[]{grid[xx][yy] , xx , yy});
                vis[xx][yy] =true; 
                }
            }
        }
        return res;
    }
}