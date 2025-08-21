class Pair{
int row= 0 ;
int col = 0;
int height =0;
    Pair(int row , int col , int height){
        this.row= row;
        this.col = col;
        this.height = height;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.height - b.height);
        pq.add(new Pair(0,0,0)); 
        int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        int dist [][] = new int[m][n];
            for(int  i =0 ;i < m ;i++){
            Arrays.fill(dist[i] , Integer.MAX_VALUE);
        }
        dist[0][0] =0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int height = curr.height;

         if(row == m-1 && col == n-1)return height;

            for(int [] temp : dir){
                 int rows = row + temp[0]; 
                 int cols = col + temp[1];
                 
                if(rows >= 0 && cols >=0 && rows < m && cols < n){
                     
                    int hit = Math.max(Math.abs(heights[row][col] - heights[rows][cols] ), height );
                    if(hit < dist[rows][cols]){
                         dist[rows][cols] = hit;
                        pq.add(new Pair(rows , cols , hit));
                    }
                }
            }
        }
        return 0;
    }
}