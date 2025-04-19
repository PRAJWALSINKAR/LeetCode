class Solution {
    //simple approch 
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(isConnected, i, vis);
            }
        }
        return count;
    }

    private void dfs(int[][] arr, int Node, boolean[] vis) {
        for (int j = 0; j < arr[Node].length; j++) {
            if (!vis[j] && arr[Node][j] != 0) {
                vis[j] = true;
                dfs(arr, j, vis);
            }
        }
    }
}