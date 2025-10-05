class Solution {
    public int trapRainWater(int[][] height) {
        int n = height.length;
        int m = height[0].length;
        if(n < 3 || m <3)return 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        boolean vis[][] = new boolean[n][m];
        for(int i =0; i < n ;i++){
            pq.offer(new int[]{height[i][0] , i , 0});
            pq.offer(new int[]{height[i][m-1] , i , m-1});
            vis[i][0] = vis[i][m-1] =true;
        }
        for(int i =0; i < m ;i++){
            pq.offer(new int[]{height[0][i] , 0 , i});
            pq.offer(new int[]{height[n-1][i] , n-1 , i});
            vis[0][i] = vis[n-1][i] =true;
        }
        int res = 0;
        int [][] direction = {{0,1} , {1,0} , {-1 ,0},{0,-1}};
        while(!pq.isEmpty()){
            int []ceil = pq.poll();
            int hght = ceil[0];
            int x = ceil[1];
            int y = ceil[2];
            for(int [] dir : direction){
                int xx = x+ dir[0];
                int yy = y + dir[1];
                if(xx>=0 && yy >= 0 && xx < n && yy  < m && vis[xx][yy] != true){
                    res += Math.max(0, hght - height[xx][yy]);
                    pq.offer(new int[]{Math.max(height[xx][yy] ,hght), xx , yy});
                    vis[xx][yy]= true;
                }
            }
        }
        return res;
    }
}