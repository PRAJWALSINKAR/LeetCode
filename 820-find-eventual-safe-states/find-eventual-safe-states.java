class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] onPath = new boolean[n];
        boolean[] safe = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis, onPath, graph, safe);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean dfs(int node , boolean[] vis , boolean[] onPath , int [][]graph , boolean [] safe){
        vis[node] = true;
        onPath[node] = true;
         
          for (int neighbor : graph[node]) {
            if (!vis[neighbor]) {
                if (dfs(neighbor, vis , onPath , graph , safe)) {
                    return true;
                }
            }
            else if(onPath[neighbor]){
                return true;
            }
        }            
        onPath[node] = false;
        safe[node] = true;
        return false;
    }
}