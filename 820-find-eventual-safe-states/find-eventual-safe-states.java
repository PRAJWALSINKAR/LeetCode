class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int n = graph.length;
        
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            revAdj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        
        // Build reversed graph
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                revAdj.get(neighbor).add(i); // Reverse the edge
                indegree[i]++; // Original node has outgoing edge
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        // Start with nodes having no outgoing edges (terminal nodes)
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        List<Integer> safeNodes = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for (int neighbor : revAdj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        
        Collections.sort(safeNodes);
        return safeNodes;
    }
}