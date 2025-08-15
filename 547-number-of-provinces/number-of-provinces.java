class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean [] vis = new boolean[n];
        for(int i =0 ; i < n ; i++){
            if(!vis[i]){
                vis[i] = true;
                count++;
                dfs(i , vis , isConnected);
            }
        }
        return count;
    }
    public void dfs(int Node , boolean [] vis ,int[][] arr ){
        for(int j = 0 ; j<arr[Node].length ; j++){
            if(!vis[j] && arr[Node][j] == 1){
                vis[j] = true;
                dfs(j , vis , arr);
            }
        }
    }
}