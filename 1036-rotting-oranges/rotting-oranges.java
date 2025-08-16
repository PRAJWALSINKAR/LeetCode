class Solution {
    
    public int orangesRotting(int[][] grid) {
        // First count Fresh Oranges AND Keep rotten oranges in Queue
        //Store Rotten oranges [row, col ] 
        Queue<int[]> q = new LinkedList();
        int row = grid.length;
        int col = grid[0].length;
        int minutes = -1;
        int fresh = 0;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // Rotten Oranges check
                if (grid[r][c] == 2) {
                    q.offer(new int[] { r, c });

                 }  //Fresh Oranges check
                else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }
        // If no fresh orange is there
        if(fresh==0) return 0;
        
// All 4 directions L R U D
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            minutes++;
            // How many rotten oranges are there; if we don't store the size BFS will traverse the newly rotten oranges which should rotten in the next minutes
            int size=q.size();

            while(size-->0){
                int[] oranges=q.poll();
                // Check all its neighbor
                for(int[] d: dir){
                    // newly rotten oranges row position
                    int nr=oranges[0]+d[0];
                    // newly rotten oranges column position
                    int nc=oranges[1]+d[1];
// check out of bounds AND if there any fresh oranges are there [in neighbors]
                    if(nr<row && nc<col && nr>=0 && nc>=0 && grid[nr][nc]==1){
                        // rotten fresh
                        grid[nr][nc]=2;
                        fresh--;
                        // Adding newly rotten oranges
                        q.offer(new int[]{nr,nc});
                    }
                }
            }


        }
        // If fresh!=0 means all oranges are not rotten. Hence return -1
return    fresh==0?minutes:-1;

    }
}