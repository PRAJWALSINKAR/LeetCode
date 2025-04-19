class Solution {
    public int findCircleNum(int[][] isConnected) {
       /* 
    1 => Calculate the length of the matrix to determine the number of nodes (n).
    2 => Create a 2D ArrayList (adjLis) where each node has its own list to store its neighbors.
    3 => Use a double loop to convert the adjacency matrix to an adjacency list. If a node `i` is connected to `j` (isConnected[i][j] == 1), add `j` to the neighbor list of `i` and vice versa (undirected graph).
    4 => Create a `vis` array to track which nodes have been visited during DFS (1 for visited, 0 for unvisited).
    5 => Apply DFS (Depth-First Search) to explore all nodes connected to the current node, marking nodes as visited.
    6 => If the DFS discovers that nodes are connected (i.e., they belong to the same connected component), increment the province count by 1.
    7 => After all nodes are visited, return the total number of provinces (connected components).
*/

        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adjLis = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjLis.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjLis.get(i).add(j);
                    adjLis.get(j).add(i);
                }
            }
        }
        int[] vis = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                count++;
                dfs(i, adjLis, vis);
            }
        }
        return count;
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adjLis, int[] vis) {
        vis[node] = 1;
        for (int nde : adjLis.get(node)) {
            if (vis[nde] == 0) {
                dfs(nde, adjLis, vis);
            }
        }
    }
}