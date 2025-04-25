class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color , -1);

        for(int i = 0 ;i<n ;i++){
            if(color[i] == -1){
                if(!dfs(i , 0 ,color , graph)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node , int colorVal , int[] color , int [][] graph){
        color[node] = colorVal;
        for(int neighbor : graph[node]){
            if(color[neighbor] == -1){
                if(!dfs(neighbor , 1 - colorVal , color , graph)) return false;
            } else if(color[neighbor] == colorVal){
                return false;
            }
        }
        return true;
    }
}