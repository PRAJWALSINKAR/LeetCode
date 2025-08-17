class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];
        boolean[] safe = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, graph, vis, path, safe);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) ans.add(i);
        }
        return ans;
    }

    private boolean dfs(int node, int[][] graph, boolean[] vis, boolean[] path, boolean[] safe) {
        vis[node] = true;
        path[node] = true;

        for (int nei : graph[node]) {
            if (!vis[nei]) {
                if (dfs(nei, graph, vis, path, safe)) {
                    return true; // cycle found → unsafe
                }
            } else if (path[nei]) {
                return true; // cycle found → unsafe
            }
        }

        path[node] = false;
        safe[node] = true; // no cycle found from this node
        return false;
    }
}
